package com.mungai.dev.onlineRecruitmentSystem.controllers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.jobRoleDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;
import com.mungai.dev.onlineRecruitmentSystem.mappers.JobRoleMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.JobRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/job-roles")
@RequiredArgsConstructor
public class JobRoleController {
    private final JobRoleService jobRoleService;
    private final JobRoleMapper jobRoleMapper;
 @PostMapping(path="/create-job-role")
    public ResponseEntity<jobRoleDto>createJobRole(@Valid @RequestBody jobRole role){
        jobRole newRole = jobRoleService.createJobRole(role);
        jobRoleDto roleDto = jobRoleMapper.toDto(newRole);
        return new ResponseEntity<>(roleDto, HttpStatus.CREATED);
    }
    @GetMapping(path="/{role_Id}")
    public ResponseEntity<jobRoleDto> getJobRole(@PathVariable UUID role_Id) {
        jobRole role = jobRoleService.getJobRole(role_Id);
        jobRoleDto roleDto = jobRoleMapper.toDto(role);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }
    @PutMapping(path="/{role_Id}")
    public ResponseEntity<jobRoleDto> updateJobRole(@PathVariable UUID role_Id, @Valid @RequestBody jobRole role) {
        jobRole updatedRole = jobRoleService.updateJobRole(role_Id, role);
        jobRoleDto roleDto = jobRoleMapper.toDto(updatedRole);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }
    @DeleteMapping(path="/{role_Id}")
    public ResponseEntity<Void> deleteJobRole(@PathVariable UUID role_Id) {
        jobRoleService.deleteJobRole(role_Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
