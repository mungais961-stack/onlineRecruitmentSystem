package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;

import java.util.List;

public record CreateDepartmentRequest(
        String department_name,
        List<Employee> employees,
        Employee manager,
        String description
) {
}
