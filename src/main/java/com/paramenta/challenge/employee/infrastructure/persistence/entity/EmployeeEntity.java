package com.paramenta.challenge.employee.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    @jakarta.persistence.Column(name = "first_name", nullable = false)
    private String firstName;
    
    @jakarta.persistence.Column(name = "last_name", nullable = false)
    private String lastName;
    
    @jakarta.persistence.Column(name = "document_type", nullable = false)
    private String documentType;
    
    @jakarta.persistence.Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;
    
    @jakarta.persistence.Column(name = "birth_date", nullable = false)
    private java.time.LocalDate birthDate;
    
    @jakarta.persistence.Column(name = "hire_date", nullable = false)
    private java.time.LocalDate hireDate;
    
    @jakarta.persistence.Column(name = "position", nullable = false)
    private String position;
    
    @jakarta.persistence.Column(name = "salary", nullable = false)
    private Double salary;
}