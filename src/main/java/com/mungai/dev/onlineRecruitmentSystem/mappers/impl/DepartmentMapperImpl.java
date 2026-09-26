package com.mungai.dev.onlineRecruitmentSystem.mappers.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.CreateDepartmentRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.mappers.DepartmentMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateDepartmentRequest;
import org.springframework.stereotype.Component;

@Component

public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public CreateDepartmentRequest fromDto(CreateDepartmentRequestDto createDepartmentRequestDto) {
        return new CreateDepartmentRequest(
                createDepartmentRequestDto.department_name(),
                createDepartmentRequestDto.employees(),
                createDepartmentRequestDto.manager(),
                createDepartmentRequestDto.description()
        );

    }

    @Override
    public CreateDepartmentRequestDto toDto(CreateDepartmentRequest createDepartmentRequest) {
        return new CreateDepartmentRequestDto(
                createDepartmentRequest.department_name(),
                createDepartmentRequest.employees(),
                createDepartmentRequest.manager(),
                createDepartmentRequest.description()
        );
    }
}
