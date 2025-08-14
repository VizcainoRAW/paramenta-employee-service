package com.paramenta.challenge.employee.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "employment_start_date", nullable = false)
    private LocalDate employmentStartDate;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String firstName, String lastName, String documentType,
                          String documentNumber, LocalDate birthDate, LocalDate employmentStartDate,
                          String jobTitle, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.employmentStartDate = employmentStartDate;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDate.now();
    }
}