package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    Department createDepartment(CreateDepartmentRequest request);

    Department getDepartmentById(UUID department_Id);

    List<Department> getAllDepartments();

    Department updateDepartment(UUID department_Id, Department department);

    void deleteDepartment(UUID department_Id);
}
