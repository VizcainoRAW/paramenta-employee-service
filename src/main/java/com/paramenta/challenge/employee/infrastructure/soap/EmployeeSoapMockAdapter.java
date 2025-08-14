package com.paramenta.challenge.employee.infrastructure.soap;

import org.springframework.stereotype.Component;
import com.paramenta.challenge.employee.domain.model.Employee;
import com.paramenta.challenge.employee.domain.spi.EmployeeSoapPort;

@Component
public class EmployeeSoapMockAdapter implements EmployeeSoapPort {

    @Override
    public void saveEmployee(Employee employee) {
        // Simulamos que el SOAP fue exitoso
        System.out.println("Mock SOAP called successfully for employee: " + employee.getFirstName() + " " + employee.getLastName());
        // No lanzamos excepciones, así el REST funciona como si fuera exitoso
    }
}
