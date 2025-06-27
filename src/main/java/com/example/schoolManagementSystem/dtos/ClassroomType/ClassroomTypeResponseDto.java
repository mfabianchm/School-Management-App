package com.example.schoolManagementSystem.dtos.ClassroomType;

public class ClassroomTypeResponseDto {
    private Long id;
    private String classroomName;

    public ClassroomTypeResponseDto() {
    }

    public ClassroomTypeResponseDto(Long id, String classroomName) {
        this.id = id;
        this.classroomName = classroomName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }
}
