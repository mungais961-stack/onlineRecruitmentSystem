package com.mungai.dev.onlineRecruitmentSystem.dtos;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
