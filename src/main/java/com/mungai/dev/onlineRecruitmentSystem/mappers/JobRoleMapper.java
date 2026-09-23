package com.mungai.dev.onlineRecruitmentSystem.mappers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.jobRoleDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;

public interface JobRoleMapper {
    //jobRole fromDto(jobRoleDto roleDto);

    jobRoleDto toDto(jobRole role);
}
