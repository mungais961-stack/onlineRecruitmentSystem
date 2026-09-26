package com.mungai.dev.onlineRecruitmentSystem.dtos;

import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;

import java.util.List;

public record CreateDepartmentRequestDto(
     String department_name,
    List<Employee> employees,
    Employee manager,
    String description
) {
}
