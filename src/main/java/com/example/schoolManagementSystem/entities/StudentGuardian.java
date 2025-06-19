package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_guardian")
public class StudentGuardian {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_guardian_seq")
    @SequenceGenerator(name = "student_guardian_seq", sequenceName = "student_guardian_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guardian_id", nullable = false)
    private Guardian guardian;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guardian_type_id", nullable = false)
    private GuardianType guardianType;

    public StudentGuardian() {}

    public StudentGuardian(Long id, Student student, Guardian guardian, GuardianType guardianType) {
        this.id = id;
        this.student = student;
        this.guardian = guardian;
        this.guardianType = guardianType;
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

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public GuardianType getGuardianType() {
        return guardianType;
    }

    public void setGuardianType(GuardianType guardianType) {
        this.guardianType = guardianType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentGuardian)) return false;
        StudentGuardian that = (StudentGuardian) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StudentGuardian{" +
                "id=" + id +
                ", studentId=" + (student != null ? student.getId() : null) +
                ", guardianId=" + (guardian != null ? guardian.getId() : null) +
                ", guardianTypeId=" + (guardianType != null ? guardianType.getId() : null) +
                '}';
    }
}
