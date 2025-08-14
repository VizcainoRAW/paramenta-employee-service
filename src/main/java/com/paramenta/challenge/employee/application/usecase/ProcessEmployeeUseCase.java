package com.paramenta.challenge.employee.application.usecase;

import org.springframework.stereotype.Service;

import com.paramenta.challenge.employee.domain.model.Employee;
import com.paramenta.challenge.employee.domain.spi.EmployeeSoapPort;
import com.paramenta.challenge.employee.application.dto.EmployeeRequestDto;
import com.paramenta.challenge.employee.application.dto.EmployeeResponseDto;

import java.time.Period;

@Service
public class ProcessEmployeeUseCase {
    
    private final EmployeeSoapPort soapPort;

    public ProcessEmployeeUseCase(EmployeeSoapPort soapPort) {
        this.soapPort = soapPort;
    }

    public EmployeeResponseDto execute(EmployeeRequestDto request) {
        Employee employee = new Employee(
            request.firstName(),
            request.lastName(),
            request.documentType(),
            request.documentNumber(),
            request.birthDate(),
            request.hireDate(),
            request.position(),
            request.salary()
        );

        Period age = employee.calculateAge();
        Period tenure = employee.calculateTenure();

        soapPort.saveEmployee(employee);

        return new EmployeeResponseDto(
            employee.getFirstName(),
            employee.getLastName(),
            employee.getDocumentType(),
            employee.getDocumentNumber(),
            employee.getBirthDate(),
            employee.getHireDate(),
            employee.getPosition(),
            employee.getSalary(),
            new EmployeeResponseDto.PeriodDTO(age.getYears(), age.getMonths(), age.getDays()),
            new EmployeeResponseDto.PeriodDTO(tenure.getYears(), tenure.getMonths(), tenure.getDays())
        );
    }
}
