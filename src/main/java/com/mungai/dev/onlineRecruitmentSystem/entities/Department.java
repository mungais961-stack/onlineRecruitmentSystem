package com.mungai.dev.onlineRecruitmentSystem.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID department_id;
    private String department_name;
    private Long manager_id;

    @OneToOne
    private Employee manager;

    @ManyToOne
    private Employee departmentHead;
}