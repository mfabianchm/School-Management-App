package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Teachers.TeacherRequestDto;
import com.example.schoolManagementSystem.dtos.Teachers.TeacherResponseDto;
import com.example.schoolManagementSystem.entities.Teacher;
import com.example.schoolManagementSystem.entities.User;

public class TeacherMapper {
    public static TeacherResponseDto toDto(Teacher teacher) {
        return new TeacherResponseDto(
                teacher.getId(),
                teacher.getTeacherFirstname(),
                teacher.getTeacherLastname(),
                teacher.getGender(),
                teacher.getEmail(),
                teacher.getPhoneNumber()
        );
    }

    public static Teacher toEntity(TeacherRequestDto dto, User user) {
        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacher.setTeacherFirstname(dto.getTeacherFirstname());
        teacher.setTeacherLastname(dto.getTeacherLastname());
        teacher.setGender(dto.getGender());
        teacher.setEmail(dto.getEmail());
        teacher.setPhoneNumber(dto.getPhoneNumber());
        return teacher;
    }

    public static void updateEntity(Teacher teacher, TeacherRequestDto dto) {
        teacher.setTeacherFirstname(dto.getTeacherFirstname());
        teacher.setTeacherLastname(dto.getTeacherLastname());
        teacher.setGender(dto.getGender());
        teacher.setEmail(dto.getEmail());
        teacher.setPhoneNumber(dto.getPhoneNumber());
    }
}
