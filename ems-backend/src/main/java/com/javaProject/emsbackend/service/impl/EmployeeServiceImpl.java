package com.javaProject.emsbackend.service.impl;

import com.javaProject.emsbackend.dto.EmployeeDto;
import com.javaProject.emsbackend.entity.Employee;
import com.javaProject.emsbackend.exception.ResourceNotFoundException;
import com.javaProject.emsbackend.mapper.EmployeeMapper;
import com.javaProject.emsbackend.repository.EmployeeRepository;
import com.javaProject.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employee.setBit(0);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(
                        () -> new ResourceNotFoundException("Employee doesn't exist with given id" + employeeId)
                );
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        employeeRepository.deleteById(employeeId);

    }


    @Override
    public void inTime(Long employeeId){//, EmployeeDto updatedEmployee) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        employee.setBit(1);
        employee.setLoginTimes(formattedTime);
        for (String time : employee.getLoginTimes()) {
            System.out.println(time);
        }
        Employee updatedEmployeeObj = employeeRepository.save(employee);


    }

    @Override
    public void outTime(Long employeeId){//, EmployeeDto updatedEmployee) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        employee.setBit(0);
        employee.setLogoutTimes(formattedTime);
        for (String time : employee.getLogoutTimes()) {
            System.out.println(time);
        }
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        employee.setBit(1);
    }

    @Override
    public List<String> getDuration(Long employeeId)//, EmployeeDto updatedEmployee)
    {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        long totalHours = 0;
        long totalMinutes = 0;

        ArrayList<String> displayTimes = new ArrayList<>();

        for (int i = 0; i < employee.getLoginTimes().size() && i < employee.getLogoutTimes().size(); i++) {
            String loginTimeStr = employee.getLoginTimes().get(i);
            String logoutTimeStr = employee.getLogoutTimes().get(i);

            if(loginTimeStr!=null && logoutTimeStr!=null) {
                displayTimes.add(loginTimeStr);
                displayTimes.add(logoutTimeStr);
                // Parse login and logout times into LocalDateTime objects
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

                // Parse login and logout times into LocalDateTime objects
                LocalDateTime loginTime = LocalDateTime.parse(loginTimeStr, formatter);
                LocalDateTime logoutTime = LocalDateTime.parse(logoutTimeStr, formatter);

                // Calculate difference between login and logout times
                Duration duration = Duration.between(loginTime, logoutTime);
                long diffHours = duration.toHours();
                long diffMinutes = duration.toMinutes() % 60;
                totalHours += diffHours;
                totalMinutes += diffMinutes;

                // Print difference
                //System.out.println("Difference for index " + i + ": " + diffHours + " hours and " + diffMinutes + " minutes.");
                System.out.println(loginTime+"--"+logoutTime);
                //System.out.println(diffHours*10 + ((float)(diffMinutes*10)/60)+"dollars");
            }
        }
        totalHours += totalMinutes / 60;
        totalMinutes %= 60;
        double dollars=ceil(totalHours*10 + ((float)(totalMinutes*10)/60));
        String str=dollars+"dollars";
        displayTimes.add(str);
        System.out.println("--------------");
        for (String i : displayTimes)
            System.out.print(i + " ");
        return displayTimes;
        //System.out.println(totalHours*10 + ((float)(totalMinutes*10)/60)+"dollars");
    }

    @Override
    public int checkBit(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee not exist" + employeeId)
        );
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return employee.getBit();
    }

    @Override
    public void deleteAll() {
//        List<Employee> employees = employeeRepository.findAll();
       employeeRepository.deleteAll();
    }


}


