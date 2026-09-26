package com.mungai.dev.onlineRecruitmentSystem.mappers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.dtos.UpdateEmployeeRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.services.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDtoList(List<Employee> employees);

    UpdateEmployeeRequest fromDto(UpdateEmployeeRequestDto updateEmployeeRequestDto);
}
