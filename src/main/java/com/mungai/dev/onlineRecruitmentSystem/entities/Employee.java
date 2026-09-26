package com.mungai.dev.onlineRecruitmentSystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table(name = "employees")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "employee_id", nullable = false, updatable = false, unique = true)
    private UUID employee_Id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "national_id", nullable = false, unique = true)
    private Long nationalId;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private jobRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @Column(name="employedAt",updatable = true)
    private LocalDateTime employedAt;
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;

    public Employee(UUID employee_Id, String firstName, String lastName, String email, String phoneNumber, String address, jobRole role, LocalDateTime employedAt, Department department) {
        this.employee_Id = employee_Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.employedAt = employedAt;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_Id, employee.employee_Id) && Objects.equals(nationalId, employee.nationalId) && Objects.equals(gender, employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_Id, nationalId, gender);
    }
    @PrePersist
    protected void onCreate(){
        LocalDateTime now = LocalDateTime.now();
        this.employedAt=now;
        this.updatedAt=now;

    }
    @PreUpdate
    protected void onUpdate(){
        LocalDateTime now = LocalDateTime.now();
        this.updatedAt=now;

    }
    //Calculate the number of years of employment.

}
