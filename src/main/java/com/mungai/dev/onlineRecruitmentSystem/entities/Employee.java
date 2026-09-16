package com.mungai.dev.onlineRecruitmentSystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "employees")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID employee_Id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    private Long nationalId;
    private Date dateOfBirth;
    private Status status;
    private String Address;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private jobRole role;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;



}
