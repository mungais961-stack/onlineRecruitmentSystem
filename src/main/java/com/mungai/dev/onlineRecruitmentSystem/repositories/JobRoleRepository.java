package com.mungai.dev.onlineRecruitmentSystem.repositories;

import com.mungai.dev.onlineRecruitmentSystem.entities.jobRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRoleRepository extends JpaRepository<jobRole, UUID> {
}
