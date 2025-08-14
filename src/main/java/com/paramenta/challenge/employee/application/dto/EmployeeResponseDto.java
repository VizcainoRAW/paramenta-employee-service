package com.paramenta.challenge.employee.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record EmployeeResponseDto(
    String firstName,
    String lastName,
    String documentType,
    String documentNumber,
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate,
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate hireDate,
    
    String position,
    Double salary,
    PeriodDTO age,
    PeriodDTO tenure
) {
    public record PeriodDTO(
        int years,
        int months,
        int days
    ) {}
}
