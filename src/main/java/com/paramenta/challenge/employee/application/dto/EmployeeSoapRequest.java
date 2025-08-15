package com.paramenta.challenge.employee.application.dto;

import java.time.LocalDate;

import com.paramenta.challenge.employee.domain.model.Employee;

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

    public EmployeeSoapRequest(Employee employee){
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.documentType = employee.getDocumentType();
        this.documentNumber = employee.getDocumentNumber();
        this.birthDate = employee.getBirthDate();
        this.hireDate = employee.getHireDate();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
    }

    public String toXml() {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:gs=\"http://www.paramenta.com/challenge/employee\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<gs:saveEmployeeRequest>" +
                "<gs:employee>" +
                "<gs:firstName>" + getFirstName() + "</gs:firstName>" +
                "<gs:lastName>" + getLastName() + "</gs:lastName>" +
                "<gs:documentType>" + getDocumentType() + "</gs:documentType>" +
                "<gs:documentNumber>" + getDocumentNumber() + "</gs:documentNumber>" +
                "<gs:birthDate>" + getBirthDate() + "</gs:birthDate>" +
                "<gs:hireDate>" + getHireDate() + "</gs:hireDate>" +
                "<gs:position>" + getPosition() + "</gs:position>" +
                "<gs:salary>" + getSalary() + "</gs:salary>" +
                "</gs:employee>" +
                "</gs:saveEmployeeRequest>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
    }

}
