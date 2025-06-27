package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Classroom.ClassroomRequestDto;
import com.example.schoolManagementSystem.dtos.Classroom.ClassroomResponseDto;
import com.example.schoolManagementSystem.entities.Classroom;
import com.example.schoolManagementSystem.entities.ClassroomTypes;

public class ClassroomMapper {
    public static Classroom toEntity(ClassroomRequestDto dto, ClassroomTypes classroomTypes) {
        Classroom classroom = new Classroom();
        classroom.setRoomName(dto.getRoomName());
        classroom.setCapacity(dto.getCapacity());
        classroom.setClassroomTypes(classroomTypes);
        return classroom;
    }

    public static void updateEntity(Classroom classroom, ClassroomRequestDto dto, ClassroomTypes classroomTypes) {
        classroom.setRoomName(dto.getRoomName());
        classroom.setCapacity(dto.getCapacity());
        classroom.setClassroomTypes(classroomTypes);
    }

    public static ClassroomResponseDto toDto(Classroom classroom) {
        return new ClassroomResponseDto(
                classroom.getId(),
                classroom.getRoomName(),
                classroom.getCapacity(),
                classroom.getClassroomTypes().getId(),
                classroom.getClassroomTypes().getClassroomName()
        );
    }
}
