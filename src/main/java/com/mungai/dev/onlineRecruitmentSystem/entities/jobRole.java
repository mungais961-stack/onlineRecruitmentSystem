package com.mungai.dev.onlineRecruitmentSystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "job_roles")
public class jobRole {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID role_Id;
    private List<Employee> employees;
    private String role_Name;
}