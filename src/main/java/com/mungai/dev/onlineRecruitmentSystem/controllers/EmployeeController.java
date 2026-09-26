package com.mungai.dev.onlineRecruitmentSystem.controllers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.EmployeeDto;
import com.mungai.dev.onlineRecruitmentSystem.entities.Employee;
import com.mungai.dev.onlineRecruitmentSystem.mappers.EmployeeMapper;
import com.mungai.dev.onlineRecruitmentSystem.services.EmployeeService;
import com.mungai.dev.onlineRecruitmentSystem.services.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

@GetMapping(path="/list-employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<Employee> employees = employeeService.listEmployees();
        List<EmployeeDto> employeeDtos = employeeMapper.toDtoList(employees);
        return  ResponseEntity.ok(employeeDtos);
    }
    @PostMapping(path="/create-employee")
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody Employee request){
    Employee employee= employeeService.createEmployee(request);
    EmployeeDto employeeDto=employeeMapper.toDto(employee);
    return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);

    }
    @GetMapping(path="/get-employee/{employee_Id}")
    public ResponseEntity<EmployeeDto>getEmployee(@PathVariable UUID employee_Id){
    Employee employee =employeeService.getEmployee(employee_Id);

    EmployeeDto employeeDto=employeeMapper.toDto(employee);
    return ResponseEntity.ok(employeeDto);
    }
    @PutMapping(path="/update-employee/{employee_Id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable UUID employee_Id,
                                                      @RequestBody UpdateEmployeeRequest request){
        Employee updatedEmployee=employeeService.updateEmployee(employee_Id,request);
        EmployeeDto employeeDto=employeeMapper.toDto(updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    @DeleteMapping(path="/delete-employee/{employee_Id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employee_Id){
        employeeService.deleteEmployee(employee_Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
