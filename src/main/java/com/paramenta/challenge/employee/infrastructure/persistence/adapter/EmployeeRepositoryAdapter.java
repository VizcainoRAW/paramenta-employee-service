package com.paramenta.challenge.employee.infrastructure.persistence.adapter;

import com.paramenta.challenge.employee.domain.model.Employee;
import com.paramenta.challenge.employee.domain.spi.EmployeeRepositoryPort;
import com.paramenta.challenge.employee.infrastructure.persistence.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryAdapter implements EmployeeRepositoryPort {

    private final EmployeeRepository employeeRepository;

    public EmployeeRepositoryAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = toJpaEntity(employee);
        employeeRepository.save(employeeEntity);
        return toDomainModel(employeeEntity);
    }

    @Override
    public Employee findByDocumentNumber(String documentNumber) {
        EmployeeEntity entity = employeeRepository.findByDocumentNumber(documentNumber);
        return toDomainModel(entity);
    }

    private EmployeeEntity toJpaEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setDocumentType(employee.getDocumentType());
        entity.setDocumentNumber(employee.getDocumentNumber());
        entity.setBirthDate(employee.getBirthDate());
        entity.setHireDate(employee.getHireDate());
        entity.setPosition(employee.getPosition());
        entity.setSalary(employee.getSalary());
        return entity;
    }

    private Employee toDomainModel(EmployeeEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Employee(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDocumentType(),
                entity.getDocumentNumber(),
                entity.getBirthDate(),
                entity.getHireDate(),
                entity.getPosition(),
                entity.getSalary()
        );
    }
}
