package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_year_level")
public class StudentYearLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_year_level_seq")
    @SequenceGenerator(name = "student_year_level_seq", sequenceName = "student_year_level_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "year_level_id", nullable = false)
    private YearLevel yearLevel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_year_id", nullable = false)
    private SchoolYear schoolYear;

    @Column(name = "score", nullable = false)
    private Integer score;

    public StudentYearLevel() {
    }

    public StudentYearLevel(Long id, Student student, YearLevel yearLevel, SchoolYear schoolYear, Integer score) {
        this.id = id;
        this.student = student;
        this.yearLevel = yearLevel;
        this.schoolYear = schoolYear;
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

    public YearLevel getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(YearLevel yearLevel) {
        this.yearLevel = yearLevel;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
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
        StudentYearLevel that = (StudentYearLevel) o;
        return Objects.equals(id, that.id) && Objects.equals(student, that.student) && Objects.equals(yearLevel, that.yearLevel) && Objects.equals(schoolYear, that.schoolYear) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, yearLevel, schoolYear, score);
    }

    @Override
    public String toString() {
        return "StudentYearLevel{" +
                "id=" + id +
                ", student=" + student +
                ", yearLevel=" + yearLevel +
                ", schoolYear=" + schoolYear +
                ", score=" + score +
                '}';
    }
}
