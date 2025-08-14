package com.paramenta.challenge.employee.application.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "EmployeeSoapResponse")
@XmlType(propOrder = {"success","message"})
public class EmployeeSoapResponse {
    private boolean success;
    private String message;

    public EmployeeSoapResponse() {}

    public EmployeeSoapResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}