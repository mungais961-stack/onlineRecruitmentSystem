package com.mungai.dev.onlineRecruitmentSystem.mappers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.dtos.UpdateEmployeeRequestDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.services.UpdateEmployeeRequest;

public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    UpdateEmployeeRequest fromDto(UpdateEmployeeRequestDto updateEmployeeRequestDto);
}
