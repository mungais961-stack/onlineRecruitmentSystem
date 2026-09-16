package com.mungai.dev.onlineRecruitmentSystem.repositories;

import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
