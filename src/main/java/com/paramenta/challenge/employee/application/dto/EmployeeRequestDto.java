package com.paramenta.challenge.employee.application;


import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public record EmployeeRequestDto(
    @NotBlank(message = "First name is required")
    String firstName,
    
    @NotBlank(message = "Last name is required")
    String lastName,
    
    @NotBlank(message = "Document type is required")
    String documentType,
    
    @NotBlank(message = "Document number is required")
    String documentNumber,
    
    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthDate,
    
    @NotNull(message = "Hire date is required")
    @PastOrPresent(message = "Hire date must be in the past or present")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate hireDate,
    
    @NotBlank(message = "Position is required")
    String position,
    
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    Double salary
) {}