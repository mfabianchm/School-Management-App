package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class SchoolSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
    @SequenceGenerator(name = "subject_seq", sequenceName = "subject_seq", allocationSize = 1)
    private Long id;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;



    // Constructors
    public SchoolSubject() {}

    public SchoolSubject(Long id, String subjectName, Department department) {
        this.id = id;
        this.subjectName = subjectName;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    // equals and hashCode (based on id)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolSubject)) return false;
        SchoolSubject schoolSubject = (SchoolSubject) o;
        return Objects.equals(getId(), schoolSubject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // toString
    @Override
    public String toString() {
        return "SchoolSubject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", department=" + (department != null ? department.getId() : null) +
                '}';
    }
}
