package com.mungai.dev.onlineRecruitmentSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "job_roles")
@NoArgsConstructor
@AllArgsConstructor
public class jobRole {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    private UUID role_Id;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "employees", nullable = true)
    private List<Employee> employees;

    @Column(name = "role_name", nullable = false)
    private String role_Name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        jobRole jobRole = (jobRole) o;
        return Objects.equals(role_Id, jobRole.role_Id) && Objects.equals(role_Name, jobRole.role_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_Id, role_Name);
    }
}