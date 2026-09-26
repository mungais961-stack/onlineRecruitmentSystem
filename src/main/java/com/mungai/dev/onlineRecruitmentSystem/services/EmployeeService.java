package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<Employee>listEmployees();

    Employee createEmployee(Employee request);

    Employee getEmployee(UUID employeeId );

    Employee updateEmployee(UUID employeeId, UpdateEmployeeRequest request);

    void deleteEmployee(UUID employeeId);
}
