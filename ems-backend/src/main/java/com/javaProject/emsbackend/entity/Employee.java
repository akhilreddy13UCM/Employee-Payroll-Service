package com.javaProject.emsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id", nullable = false, unique = true )
    private String email;

    @Column(name="in_time")
    ArrayList<String> loginTimes = new ArrayList<>();

    @Column(name="out_time")
    ArrayList<String> logoutTimes = new ArrayList<>();

    @Column(name="duration")
    ArrayList<Long> duration = new ArrayList<>();

    @Column(name="bit", nullable = false)
    private int bit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getLoginTimes() {
        if (loginTimes == null) {
            loginTimes = new ArrayList<>();
        }
        //loginTimes = new ArrayList<>();
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.getLoginTimes().add(loginTimes);
    }

    public ArrayList<String> getLogoutTimes() {
        if (logoutTimes == null) {
            logoutTimes = new ArrayList<>();
        }
        //logoutTimes = new ArrayList<>();
        return logoutTimes;
    }

    public void setLogoutTimes(String logoutTimes) {
        this.getLogoutTimes().add(logoutTimes);
    }

    public ArrayList<Long> getDuration() {
        if(duration==null){
            duration=new ArrayList<>();
        }
        return duration;
    }

    public void setDuration(Long duration) {
        this.getDuration().add(duration);
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = 1- this.bit;
    }
}
