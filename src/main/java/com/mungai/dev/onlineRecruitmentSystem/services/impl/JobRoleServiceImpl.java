package com.mungai.dev.onlineRecruitmentSystem.services.impl;

import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.RoleNotFoundException;
import com.mungai.dev.onlineRecruitmentSystem.repositories.JobRoleRepository;
import com.mungai.dev.onlineRecruitmentSystem.services.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class JobRoleServiceImpl implements JobRoleService {

    private final JobRoleRepository jobRoleRepository;

    @Override
    public jobRole createJobRole(jobRole role) {
        jobRole newRole = new jobRole();
        newRole.setRole_Name(role.getRole_Name());
        newRole.setRole_Description(role.getRole_Description());

        return jobRoleRepository.save(newRole);
    }

    @Override
    public List<jobRole> listJobRoles() {
        return jobRoleRepository.findAll();
    }

    @Override
    public jobRole getJobRole(UUID role_Id) {
        return jobRoleRepository.findById(role_Id)
                .orElseThrow(() -> new RoleNotFoundException(role_Id));
    }

    @Override
    public jobRole updateJobRole(UUID role_Id, jobRole role) {
        jobRole roleToUpdate= jobRoleRepository.findById(role_Id)
                .orElseThrow(() -> new RoleNotFoundException(role_Id));
        roleToUpdate.setRole_Name(role.getRole_Name());
        roleToUpdate.setRole_Description(role.getRole_Description());
        return jobRoleRepository.save(roleToUpdate);
    }

    @Override
    public void deleteJobRole(UUID role_Id) {
        jobRole roleToDelete = jobRoleRepository.findById(role_Id)
                .orElseThrow(() -> new RoleNotFoundException(role_Id));
        jobRoleRepository.delete(roleToDelete);

    }
}
