package com.mungai.dev.onlineRecruitmentSystem.services;

import java.time.LocalDateTime;
public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        String jobRole,
        LocalDateTime employedAt,
        String department
) {
}
