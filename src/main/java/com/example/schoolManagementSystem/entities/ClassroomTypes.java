package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "classroom_types")
public class ClassroomTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroomtypes_seq")
    @SequenceGenerator(name = "classroomtypes_seq", sequenceName = "classroomtypes_seq", allocationSize = 1)
    private Long id;

    @Column(name = "classroom_name", nullable = false)
    private String classroomName;

    // Constructors
    public ClassroomTypes() {}

    public ClassroomTypes(Long id, String classroomName) {
        this.id = id;
        this.classroomName = classroomName;
    }

    // Getters and Setters
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassroomTypes)) return false;
        ClassroomTypes that = (ClassroomTypes) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClassroomTypes{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                '}';
    }
}
