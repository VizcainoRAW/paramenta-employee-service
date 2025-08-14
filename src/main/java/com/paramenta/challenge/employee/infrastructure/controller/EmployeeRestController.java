package com.paramenta.challenge.employee.infrastructure.controller;

import com.paramenta.challenge.employee.application.dto.EmployeeRequestDto;
import com.paramenta.challenge.employee.application.dto.EmployeeResponseDto;
import com.paramenta.challenge.employee.application.dto.ValidationErrorDto;
import com.paramenta.challenge.employee.application.usecase.ProcessEmployeeUseCase;
import com.paramenta.challenge.employee.domain.exception.BusinessException;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final ProcessEmployeeUseCase useCase;

    public EmployeeRestController(ProcessEmployeeUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processEmployee(
            @Valid @RequestBody EmployeeRequestDto request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            ValidationErrorDto errorResponse =
                    new ValidationErrorDto("Validation failed", errors);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {
            EmployeeResponseDto response = useCase.execute(request);
            return ResponseEntity.ok(response);
        } catch (BusinessException e) {
            Map<String, String> errors = new HashMap<>();
            errors.put("business", e.getMessage());
            ValidationErrorDto errorResponse =
                    new ValidationErrorDto("Business validation failed", errors);
            return ResponseEntity.badRequest().body(errorResponse);
        } 
    }
} 