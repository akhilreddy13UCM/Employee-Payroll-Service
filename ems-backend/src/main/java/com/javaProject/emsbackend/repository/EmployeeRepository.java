package com.javaProject.emsbackend.repository;

import com.javaProject.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    @Query(value="delete from Employee")
//    public int deleteAllr();



}
