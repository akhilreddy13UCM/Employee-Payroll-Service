package com.javaProject.emsbackend.mapper;

import com.javaProject.emsbackend.dto.EmployeeDto;
import com.javaProject.emsbackend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getLoginTimes(),
                employee.getLogoutTimes(),
                employee.getDuration(),
                employee.getBit()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getLoginTimes(),
                employeeDto.getLogoutTimes(),
                employeeDto.getDuration(),
                employeeDto.getBit()
        );
    }

}
