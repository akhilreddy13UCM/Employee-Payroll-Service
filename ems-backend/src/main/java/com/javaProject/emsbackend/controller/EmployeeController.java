package com.javaProject.emsbackend.controller;

import com.javaProject.emsbackend.dto.EmployeeDto;
import com.javaProject.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId)
    {
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build getall employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update employee RESTAPI
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build delete employee RESTAPI
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("employee deleted successfully");
    }

    @PutMapping("/inTime/{id}")
    public ResponseEntity<String> inTime(@PathVariable("id") Long employeeId)//,@RequestBody EmployeeDto updatedEmployee)
    {
        employeeService.inTime(employeeId);//,updatedEmployee);
        return ResponseEntity.ok("logged in");
    }

    @PutMapping("/outTime/{id}")
    public ResponseEntity<String> outTime(@PathVariable("id") Long employeeId)//,@RequestBody EmployeeDto updatedEmployee)
    {
        employeeService.outTime(employeeId);//,updatedEmployee);
        return ResponseEntity.ok("logged out");
    }

    @GetMapping("/duration/{id}")
    public ResponseEntity< List<String> > getDuration(@PathVariable("id") Long employeeId)//,@RequestBody EmployeeDto updatedEmployee)
    {
        List<String>dis=employeeService.getDuration(employeeId);//,updatedEmployee);
        return ResponseEntity.ok(dis);
    }

    @GetMapping("/bit/{id}")
    public ResponseEntity<Integer> checkBit(@PathVariable("id") Long employeeId)
    {
        int bit=employeeService.checkBit(employeeId);
        return ResponseEntity.ok(bit);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll()
    {
        employeeService.deleteAll();
        return ResponseEntity.ok("jk k ");
    }


}
