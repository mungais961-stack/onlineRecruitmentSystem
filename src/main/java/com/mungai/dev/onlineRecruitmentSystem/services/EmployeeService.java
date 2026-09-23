package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<EmployeeDto>listEmployees(Employee employee);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(UUID employeeId );

    EmployeeDto updateEmployee(UUID employeeId, EmployeeDto employeeDto);

    void deleteEmployee(UUID employeeId);
}
