package com.mungai.dev.onlineRecruitmentSystem.services.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.services.EmployeeService;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<EmployeeDto> listEmployees(Employee employee) {
        return List.of();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto getEmployee(UUID employeeId) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(UUID employeeId, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteEmployee(UUID employeeId) {

    }
}
