package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroom_seq")
    @SequenceGenerator(name = "classroom_seq", sequenceName = "classroom_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classroom_type_id", nullable = false)
    private ClassroomTypes classroomTypes;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    // Constructors
    public Classroom() {}

    public Classroom(Long id, ClassroomTypes classroomTypes, String roomName, int capacity) {
        this.id = id;
        this.classroomTypes = classroomTypes;
        this.roomName = roomName;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassroomTypes getClassroomTypes() {
        return classroomTypes;
    }

    public void setClassroomTypes(ClassroomTypes classroomTypes) {
        this.classroomTypes = classroomTypes;
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

    // equals and hashCode based only on ID (recommended for JPA entities)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return Objects.equals(id, classroom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroomTypes=" + classroomTypes +
                ", roomName='" + roomName + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}