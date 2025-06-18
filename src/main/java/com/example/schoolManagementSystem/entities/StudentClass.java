package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_class_seq")
    @SequenceGenerator(name = "student_class_seq", sequenceName = "student_class_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_class_id", nullable = false)
    private SchoolClass schoolClass;

    @Column(name = "score", nullable = false)
    private Integer score;

    public StudentClass() {
    }

    public StudentClass(Long id, Student student, SchoolClass schoolClass, Integer score) {
        this.id = id;
        this.student = student;
        this.schoolClass = schoolClass;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return Objects.equals(id, that.id) && Objects.equals(student, that.student) && Objects.equals(schoolClass, that.schoolClass) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, schoolClass, score);
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", student=" + student +
                ", schoolClass=" + schoolClass +
                ", score=" + score +
                '}';
    }
}
