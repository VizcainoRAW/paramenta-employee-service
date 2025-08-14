package com.paramenta.challenge.employee.application.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeSoapRequest {

    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String position;
    private Double salary;


    public EmployeeSoapRequest() {}

    public EmployeeSoapRequest(String firstName, String lastName, String documentType, String documentNumber,
                                LocalDate birthDate, LocalDate hireDate, String position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.position = position;
        this.salary = salary;
    }

}