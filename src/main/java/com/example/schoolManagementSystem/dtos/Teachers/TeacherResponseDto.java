package com.example.schoolManagementSystem.dtos.Teachers;

import com.example.schoolManagementSystem.enums.Gender;

public class TeacherResponseDto {
    private Long id;
    private String teacherFirstname;
    private String teacherLastname;
    private Gender gender;
    private String email;
    private String phoneNumber;

    public TeacherResponseDto() {}

    public TeacherResponseDto(Long id, String teacherFirstname, String teacherLastname, Gender gender, String email, String phoneNumber) {
        this.id = id;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
