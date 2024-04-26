package com.javaProject.emsbackend.service;

import com.javaProject.emsbackend.dto.EmployeeDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
    void inTime(Long employeeId);//,EmployeeDto updatedEmployee);
    void outTime(Long employeeId);//,EmployeeDto updatedEmployee);
    List<String> getDuration(Long employeeId);//,EmployeeDto updatedEmployee);
    int checkBit(Long employeeId);
    void deleteAll();



}
