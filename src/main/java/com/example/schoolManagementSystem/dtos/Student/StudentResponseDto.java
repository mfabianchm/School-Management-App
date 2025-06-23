package com.example.schoolManagementSystem.dtos.Student;

import com.example.schoolManagementSystem.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class StudentResponseDto {
    private Long id;
    private String studentFirstname;
    private String studentLastname;
    private LocalDate dateOfBirth;
    private Gender gender;
    private LocalDate enrolmentDate;

    public StudentResponseDto() {
    }

    public StudentResponseDto(Long id, String studentFirstname, String studentLastname, LocalDate dateOfBirth, Gender gender, LocalDate enrolmentDate) {
        this.id = id;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrolmentDate = enrolmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }
}
