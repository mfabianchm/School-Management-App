package com.example.schoolManagementSystem.dtos.Student;

import com.example.schoolManagementSystem.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class StudentDto {
    private Long id;

    @NotBlank
    private String studentFirstname;

    @NotBlank
    private String studentLastname;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate enrolmentDate;

    public StudentDto() {
    }

    public StudentDto(String studentFirstname, String studentLastname, LocalDate dateOfBirth, Gender gender, LocalDate enrolmentDate) {
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
}
