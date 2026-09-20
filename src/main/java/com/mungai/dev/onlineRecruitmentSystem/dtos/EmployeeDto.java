package com.mungai.dev.onlineRecruitmentSystem.dtos;

import com.mungai.dev.onlineRecruitmentSystem.entities.Department;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.entities.Status;
import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

public record EmployeeDto(
        @NotBlank
        @Length(max=20,message = ERROR_MESSAGE_NAME_LENGTH)
        @Pattern(regexp = "^[\\w\\s-]+$",message = "Category name can only contain letters,numbers,spaces and hyphens")
        String first_name,

        @NotBlank
        @Length(max=20,message = ERROR_MESSAGE_NAME_LENGTH)
        @Pattern(regexp = "^[\\w\\s-]+$",message = "Category name can only contain letters,numbers,spaces and hyphens")
        String last_name,

        @NotBlank
        @Length(max=100,message =ERROR_MESSAGE_EMAIL_LENGTH )
        String email,

        @Nullable
        @Length(min=10,max=13,message=ERROR_PHONE_NUMBER_LENGTH)
        @NumberFormat(style = NumberFormat.Style.NUMBER)
        String phoneNumber,

        @NotBlank
        Status status,

        @Nullable
        String address,

        @Nullable
        String gender,

        @NotBlank
        Department department,

        @NotBlank
        jobRole role,

        @NotBlank
        Employee manager


) {
    private static final String ERROR_MESSAGE_NAME_LENGTH =
            "A name must be between 1 and 20 characters long. ";
    private static final String ERROR_MESSAGE_EMAIL_LENGTH =
            "Email can only be between 1 and 100 characters";
    private static final String ERROR_PHONE_NUMBER_LENGTH =
            "Phone number has to be 10 characters maximum if it starts with 07... else 13 characters max if it starts with +2547...";
}
