package com.example.schoolManagementSystem.dtos.Classroom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClassroomRequestDto {
    @NotBlank
    private String roomName;

    @NotNull
    private Integer capacity;

    @NotNull
    private Long classroomTypeId;

    public ClassroomRequestDto() {
    }

    public ClassroomRequestDto(String roomName, Integer capacity, Long classroomTypeId) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.classroomTypeId = classroomTypeId;
    }

    // Getters and Setters
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Long getClassroomTypeId() {
        return classroomTypeId;
    }

    public void setClassroomTypeId(Long classroomTypeId) {
        this.classroomTypeId = classroomTypeId;
    }
}
