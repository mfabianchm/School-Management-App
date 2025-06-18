package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import javax.security.auth.Subject;
import java.util.Objects;

@Entity
@Table(name = "classes")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_class_seq")
    @SequenceGenerator(name = "school_class_seq", sequenceName = "school_class_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SchoolSubject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;

    @ManyToOne
    @JoinColumn(name = "start_period_id", nullable = false)
    private Period startPeriod;

    @ManyToOne
    @JoinColumn(name = "end_period_id", nullable = false)
    private Period endPeriod;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    // Constructors
    public SchoolClass() {
    }

    public SchoolClass(Long id, String name, Subject subject, Teacher teacher,
                       Term term, Period startPeriod, Period endPeriod, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.teacher = teacher;
        this.term = term;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.classroom = classroom;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Period getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Period startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Period getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Period endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    // equals and hashCode based on id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolClass)) return false;
        SchoolClass that = (SchoolClass) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // toString method

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + (subject != null ? subject.getId() : null) +
                ", teacher=" + (teacher != null ? teacher.getId() : null) +
                ", term=" + (term != null ? term.getId() : null) +
                ", startPeriod=" + (startPeriod != null ? startPeriod.getId() : null) +
                ", endPeriod=" + (endPeriod != null ? endPeriod.getId() : null) +
                ", classroom=" + (classroom != null ? classroom.getId() : null) +
                '}';
    }
}
