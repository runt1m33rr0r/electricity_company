package com.electricity_company.repositories;

import com.electricity_company.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    Employee findByUserEmail(String email);
}