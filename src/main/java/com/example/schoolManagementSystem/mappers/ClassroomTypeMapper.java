package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Classroom.ClassroomRequestDto;
import com.example.schoolManagementSystem.dtos.Classroom.ClassroomResponseDto;
import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeRequestDto;
import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeResponseDto;
import com.example.schoolManagementSystem.entities.Classroom;
import com.example.schoolManagementSystem.entities.ClassroomTypes;

public class ClassroomTypeMapper {
    public static ClassroomTypes toEntity(ClassroomTypeRequestDto dto) {
        ClassroomTypes classroomType = new ClassroomTypes();
        classroomType.setClassroomName(dto.getClassroomName());
        return classroomType;
    }

    public static void updateEntity(ClassroomTypes classroom, ClassroomTypeRequestDto dto) {
        classroom.setClassroomName(dto.getClassroomName());
    }

    public static ClassroomTypeResponseDto toDto(ClassroomTypes classroom) {
        return new ClassroomTypeResponseDto(
                classroom.getId(),
                classroom.getClassroomName()
        );
    }
}
