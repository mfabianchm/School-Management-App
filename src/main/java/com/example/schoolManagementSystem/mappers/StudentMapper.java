package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Student.StudentRequestDto;
import com.example.schoolManagementSystem.dtos.Student.StudentResponseDto;
import com.example.schoolManagementSystem.dtos.Student.StudentUpdateRequestDto;
import com.example.schoolManagementSystem.entities.Student;
import com.example.schoolManagementSystem.entities.User;

public class StudentMapper {
    public static StudentResponseDto toDto(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getStudentFirstname(),
                student.getStudentLastname(),
                student.getDateOfBirth(),
                student.getGender(),
                student.getEnrolmentDate()
        );
    }

    public static Student toEntity(StudentRequestDto dto, User user) {
        Student student = new Student();
        student.setUser(user);
        student.setStudentFirstname(dto.getStudentFirstname());
        student.setStudentLastname(dto.getStudentLastname());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setGender(dto.getGender());
        student.setEnrolmentDate(dto.getEnrolmentDate());
        return student;
    }

    public static void updateEntity(Student student, StudentUpdateRequestDto dto) {
        student.setStudentFirstname(dto.getStudentFirstname());
        student.setStudentLastname(dto.getStudentLastname());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setGender(dto.getGender());
        student.setEnrolmentDate(dto.getEnrolmentDate());
    }
}
