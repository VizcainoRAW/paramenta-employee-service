package com.paramenta.challenge.employee.domain.spi;

import com.paramenta.challenge.employee.domain.model.Employee;

public interface EmployeeRepositoryPort {
    Employee save(Employee employee);
    Employee findByDocumentNumber(String documentNumber);
}