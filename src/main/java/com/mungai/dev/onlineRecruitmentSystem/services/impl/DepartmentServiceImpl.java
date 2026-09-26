package com.mungai.dev.onlineRecruitmentSystem.services.impl;

import com.mungai.dev.onlineRecruitmentSystem.entities.Department;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.DepartmentNotFoundException;
import com.mungai.dev.onlineRecruitmentSystem.repositories.DepartmentRepository;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateDepartmentRequest;
import com.mungai.dev.onlineRecruitmentSystem.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public Department createDepartment(CreateDepartmentRequest request) {
        Department newDepartment = new Department();
        newDepartment.setDepartment_name(request.department_name());
        newDepartment.setDescription(request.description());
        newDepartment.setManager(request.manager());
        newDepartment.setEmployees(request.employees());

        return departmentRepository.save(newDepartment);
    }

    @Override
    public Department getDepartmentById(UUID department_Id) {
        return departmentRepository.findById(department_Id)
                .orElseThrow(()->new DepartmentNotFoundException(department_Id));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(UUID department_Id, Department department) {
        Department departmentToUpdate = departmentRepository.findById(department_Id)
                .orElseThrow(()->new DepartmentNotFoundException(department_Id));
        departmentToUpdate.setDepartment_name(department.getDepartment_name());
        departmentToUpdate.setEmployees(department.getEmployees());
        departmentToUpdate.setManager(department.getManager());
        return departmentRepository.save(departmentToUpdate);
    }

    @Override
    public void deleteDepartment(UUID department_Id) {
        Department departmentToDelete = departmentRepository.findById(department_Id)
                .orElseThrow(()->new DepartmentNotFoundException(department_Id));
        departmentRepository.delete(departmentToDelete);
    }
}
