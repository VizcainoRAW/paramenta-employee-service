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

    public String toXml() {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:gs=\"http://www.paramenta.com/challenge/employee\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<gs:saveEmployeeResponse>" +
            "<gs:success>" + isSuccess() + "</gs:success>" +
            "<gs:message>" + getMessage() + "</gs:message>" +
            "</gs:saveEmployeeResponse>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";
    }

}