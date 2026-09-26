package com.mungai.dev.onlineRecruitmentSystem.mappers.impl;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.dtos.UpdateEmployeeRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.mappers.EmployeeMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.UpdateEmployeeRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getPhoneNumber(),
              employee.getFirstName(),
              employee.getLastName(),
                employee.getEmail(),
                employee.getStatus(),
                employee.getGender(),
                employee.getAddress(),
                employee.getDepartment(),
                employee.getRole(),
                employee.getManager()

        );
    }

    @Override
    public List<EmployeeDto> toDtoList(List<Employee> employees) {
        if(employees == null || employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees.stream()
                .map(this::toDto)
                .toList();

    }

    @Override
    public UpdateEmployeeRequest fromDto(UpdateEmployeeRequestDto updateEmployeeRequestDto) {

        return new UpdateEmployeeRequest(
                updateEmployeeRequestDto.firstName(),
                updateEmployeeRequestDto.lastName(),
                updateEmployeeRequestDto.email(),
                updateEmployeeRequestDto.phoneNumber(),
                updateEmployeeRequestDto.status(),
                updateEmployeeRequestDto.address(),
                updateEmployeeRequestDto.department(),
                updateEmployeeRequestDto.role(),
                updateEmployeeRequestDto.manager()


        );
    }
}
