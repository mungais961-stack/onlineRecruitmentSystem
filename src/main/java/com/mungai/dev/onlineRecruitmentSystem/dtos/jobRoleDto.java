package com.mungai.dev.onlineRecruitmentSystem.dtos;

import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record jobRoleDto(
        List<Employee> employees,

        @NotNull
        String role_Name,

        @Nullable
        String description

) {
}
