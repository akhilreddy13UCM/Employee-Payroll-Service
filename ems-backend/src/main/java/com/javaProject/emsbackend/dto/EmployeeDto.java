package com.javaProject.emsbackend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private ArrayList<String> loginTimes = new ArrayList<>();
        private ArrayList<String> logoutTimes = new ArrayList<>();
        private ArrayList<Long> duration = new ArrayList<>();
        private int bit;
}
