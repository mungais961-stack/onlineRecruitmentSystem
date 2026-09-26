package com.mungai.dev.onlineRecruitmentSystem.controllers;

import com.mungai.dev.onlineRecruitmentSystem.entities.Department;
import com.mungai.dev.onlineRecruitmentSystem.mappers.DepartmentMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateDepartmentRequest;
import com.mungai.dev.onlineRecruitmentSystem.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @PostMapping(path = "/create-department")
    public ResponseEntity<Department> createDepartment(@RequestBody CreateDepartmentRequest request) {
        Department department = departmentService.createDepartment(request);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-department/{department_Id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable UUID department_Id) {
        Department department = departmentService.getDepartmentById(department_Id);
        return ResponseEntity.ok(department);
    }

    @PutMapping(path = "/update-department/{department_Id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable UUID department_Id,
                                                       @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(department_Id, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping(path = "/delete-department/{department_Id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable UUID department_Id) {
        departmentService.deleteDepartment(department_Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}