package com.mungai.dev.onlineRecruitmentSystem.services.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.UserNotFoundException;
import com.mungai.dev.onlineRecruitmentSystem.repositories.EmployeeRepository;
import com.mungai.dev.onlineRecruitmentSystem.services.CreateEmployeeRequest;
import com.mungai.dev.onlineRecruitmentSystem.services.EmployeeService;
import com.mungai.dev.onlineRecruitmentSystem.services.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployees(Employee employee) {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "employedAt"));

    }

    @Override
    public Employee createEmployee(Employee request) {
        Employee employee = new Employee(
        null,
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAddress(),
                request.getRole(),
                request.getEmployedAt(),
                request.getDepartment()
        );

        return employeeRepository.save(employee);

    }



    @Override
    public Employee getEmployee(UUID employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new UserNotFoundException(employeeId));
    }

    @Override
    public Employee updateEmployee(UUID employeeId, UpdateEmployeeRequest request) {
        Employee empToUpdate=employeeRepository.findById(employeeId)
                .orElseThrow(() -> new UserNotFoundException(employeeId));
        empToUpdate.setFirstName(request.firstName());
        empToUpdate.setLastName(request.lastName());
        empToUpdate.setEmail(request.email());
        empToUpdate.setPhoneNumber(request.phoneNumber());
        empToUpdate.setAddress(request.address());
        empToUpdate.setRole(request.role());
        empToUpdate.setDepartment(request.department());
        empToUpdate.setManager(request.manager());
        empToUpdate.setStatus(request.status());
        return employeeRepository.save(empToUpdate);
    }


    @Override
    public void deleteEmployee(UUID employeeId) {
        Employee empToDelete=employeeRepository.findById(employeeId)
                .orElseThrow(() -> new UserNotFoundException(employeeId));
        employeeRepository.delete(empToDelete);

    }
}
