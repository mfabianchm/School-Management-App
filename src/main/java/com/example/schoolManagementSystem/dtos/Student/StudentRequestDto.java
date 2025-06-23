package com.example.schoolManagementSystem.dtos.Student;

import com.example.schoolManagementSystem.enums.Gender;
import com.example.schoolManagementSystem.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class StudentRequestDto {
    @NotBlank
    private String studentFirstname;
    @NotBlank private String studentLastname;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull private Gender gender;
    @NotNull private LocalDate enrolmentDate;

    // User-specific fields required for registration
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 6)
    private String password;

    // Optional, defaults to STUDENT
    private Role role = Role.STUDENT;

    public StudentRequestDto() {
    }


    public StudentRequestDto(String studentFirstname, String studentLastname, LocalDate dateOfBirth, Gender gender,
                             LocalDate enrolmentDate, String username, String email, String password, Role role) {
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrolmentDate = enrolmentDate;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role != null ? role : Role.STUDENT;
    }

    // Getters and Setters

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role != null ? role : Role.STUDENT;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
