package com.mungai.dev.onlineRecruitmentSystem.mappers.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.jobRoleDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;
import com.mungai.dev.onlineRecruitmentSystem.mappers.JobRoleMapper;
import org.springframework.stereotype.Component;

@Component
public class JobRoleMapperImpl implements JobRoleMapper {

    @Override
    public jobRoleDto toDto(jobRole role) {
        return new jobRoleDto(
             role.getRole_Id(),
             role.getEmployees(),
                role.getRole_Name(),
                role.getRole_Description()
        );
    }
}
