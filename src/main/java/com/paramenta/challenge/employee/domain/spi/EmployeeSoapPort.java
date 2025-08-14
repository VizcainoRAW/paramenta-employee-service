package com.paramenta.challenge.employee.domain.spi;

import com.paramenta.challenge.employee.domain.model.Employee;

public interface EmployeeSoapPort {
    void saveEmployee(Employee employee);
}
