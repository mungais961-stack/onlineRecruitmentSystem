package com.mungai.dev.onlineRecruitmentSystem.exceptions;

import java.util.UUID;

public class DepartmentNotFoundException extends RuntimeException {
    private final UUID department_Id;

    public UUID getDepartment_Id() {
        return department_Id;
    }
    public DepartmentNotFoundException(UUID department_Id) {
        this.department_Id = department_Id;
        super(String.format("Department with id %s not found", department_Id));

    }
}
