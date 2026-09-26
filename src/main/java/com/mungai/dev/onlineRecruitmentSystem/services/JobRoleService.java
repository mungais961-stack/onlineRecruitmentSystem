package com.mungai.dev.onlineRecruitmentSystem.services;

import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;

import java.util.List;
import java.util.UUID;

public interface JobRoleService {
    jobRole createJobRole(jobRole role);

    List<jobRole> listJobRoles();

    jobRole getJobRole(UUID role_Id);

    jobRole updateJobRole(UUID role_Id, jobRole role);

    void deleteJobRole(UUID role_Id);

}
