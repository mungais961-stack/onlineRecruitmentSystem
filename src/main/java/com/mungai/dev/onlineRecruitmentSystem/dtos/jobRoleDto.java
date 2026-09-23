package com.mungai.dev.onlineRecruitmentSystem.dtos;

import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record jobRoleDto(
        UUID role_Id,
        List<Employee> employees,

        @NotNull
        String role_Name,

        @Nullable
        String description

) {
}
