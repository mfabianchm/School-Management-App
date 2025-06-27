package com.example.schoolManagementSystem.dtos.ClassroomType;

public class ClassroomTypeRequestDto {
    private String classroomName;

    public ClassroomTypeRequestDto() {}

    public ClassroomTypeRequestDto(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
}
