package com.paramenta.challenge.employee.infrastructure.persistence.adapter;

import com.paramenta.challenge.employee.infrastructure.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByDocumentNumber(String documentNumber);
}
