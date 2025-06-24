package com.example.schoolManagementSystem.dtos.Teachers;

import com.example.schoolManagementSystem.enums.Gender;
import com.example.schoolManagementSystem.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TeacherRequestDto {
    @NotBlank
    private String teacherFirstname;

    @NotBlank
    private String teacherLastname;

    @NotNull
    private Gender gender;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    // User fields (for creation)
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    private Role role = Role.TEACHER;

    public TeacherRequestDto() {}

    public TeacherRequestDto(String teacherFirstname, String teacherLastname, Gender gender, String email, String phoneNumber, String username, String password, Role role) {
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.role = role != null ? role : Role.TEACHER;
    }

    // Getters and setters

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role != null ? role : Role.TEACHER;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
