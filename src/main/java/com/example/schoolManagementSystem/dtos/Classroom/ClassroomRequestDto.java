package com.example.schoolManagementSystem.dtos.Classroom;

public class ClassroomRequestDto {
    private String roomName;
    private int capacity;
    private Long classroomTypeId;

    public ClassroomRequestDto() {
    }

    public ClassroomRequestDto(String roomName, int capacity, Long classroomTypeId) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.classroomTypeId = classroomTypeId;
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

    public Long getClassroomTypeId() {
        return classroomTypeId;
    }

    public void setClassroomTypeId(Long classroomTypeId) {
        this.classroomTypeId = classroomTypeId;
    }
}
