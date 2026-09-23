package com.mungai.dev.onlineRecruitmentSystem.mappers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.CreateDepartmentRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateDepartmentRequest;

public interface DepartmentMapper {
    CreateDepartmentRequest fromDto(CreateDepartmentRequestDto createDepartmentRequestDto);

    CreateDepartmentRequestDto toDto(CreateDepartmentRequest createDepartmentRequest);
}
