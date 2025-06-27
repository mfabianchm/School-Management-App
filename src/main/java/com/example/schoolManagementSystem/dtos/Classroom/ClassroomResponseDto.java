package com.example.schoolManagementSystem.dtos.Classroom;

public class ClassroomResponseDto {
    private Long id;
    private String roomName;
    private Integer capacity;
    private Long classroomTypeId;
    private String classroomTypeName;

    public ClassroomResponseDto(Long id, String roomName, Integer capacity, Long classroomTypeId, String classroomTypeName) {
        this.id = id;
        this.roomName = roomName;
        this.capacity = capacity;
        this.classroomTypeId = classroomTypeId;
        this.classroomTypeName = classroomTypeName;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Long getClassroomTypeId() {
        return classroomTypeId;
    }

    public String getClassroomTypeName() {
        return classroomTypeName;
    }
}
