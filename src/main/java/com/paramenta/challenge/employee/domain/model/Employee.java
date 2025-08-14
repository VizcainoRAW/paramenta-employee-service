package com.paramenta.challenge.employee.domain.model;

import com.paramenta.challenge.employee.domain.exception.BusinessException;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class Employee {
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String position;
    private Double salary;

    public Employee(String firstName, String lastName, String documentType, 
                   String documentNumber, LocalDate birthDate, LocalDate hireDate, 
                   String position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.position = position;
        this.salary = salary;
        
        validateBusinessRules();
    }

    private void validateBusinessRules() {
        if (birthDate != null) {
            Period age = calculateAge();
            if (age.getYears() < 18) {
                throw new BusinessException("Employee must be at least 18 years old");
            }
        }
    }

    public Period calculateAge() {
        return Period.between(birthDate, LocalDate.now());
    }

    public Period calculateTenure() {
        return Period.between(hireDate, LocalDate.now());
    }
}