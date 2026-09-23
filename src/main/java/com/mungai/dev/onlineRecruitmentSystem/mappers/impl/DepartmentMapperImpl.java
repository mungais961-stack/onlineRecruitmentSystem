package com.mungai.dev.onlineRecruitmentSystem.mappers.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.CreateDepartmentRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.mappers.DepartmentMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateDepartmentRequest;

public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public CreateDepartmentRequest fromDto(CreateDepartmentRequestDto createDepartmentRequestDto) {

        return new CreateDepartmentRequest(
                createDepartmentRequestDto.department_name(),
                createDepartmentRequestDto.description()
        );
    }

    @Override
    public CreateDepartmentRequestDto toDto(CreateDepartmentRequest createDepartmentRequest) {
        return new CreateDepartmentRequestDto(
                createDepartmentRequest.department_name(),
                createDepartmentRequest.description()
        );
    }
}
