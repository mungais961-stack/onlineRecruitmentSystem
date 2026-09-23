package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.entities.Department;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.entities.Status;
import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;

public record UpdateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Status status,
        String address,
        Department department,
        jobRole role,
        Employee manager
) {
}
