package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "classroom_types")
public class ClassroomTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroomtypes_seq")
    @SequenceGenerator(name = "classroomtypes_seq", sequenceName = "classroomtypes_seq", allocationSize = 1)
    private Long id;

    @Column(name = "classroom_name", nullable = false)
    private String classroomName;
}
