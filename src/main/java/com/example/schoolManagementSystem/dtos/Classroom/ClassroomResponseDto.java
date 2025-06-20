package com.example.schoolManagementSystem.dtos.Classroom;

public class ClassroomResponseDto {
    private Long id;
    private String roomName;
    private int capacity;
    private String classroomTypeName;

    public ClassroomResponseDto() {
    }

    public ClassroomResponseDto(Long id, String roomName, int capacity, String classroomTypeName) {
        this.id = id;
        this.roomName = roomName;
        this.capacity = capacity;
        this.classroomTypeName = classroomTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassroomTypeName() {
        return classroomTypeName;
    }

    public void setClassroomTypeName(String classroomTypeName) {
        this.classroomTypeName = classroomTypeName;
    }
}
