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

    @Column(name = "name", nullable = false)
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

    @ManyToOne()
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    // Constructors
    public SchoolClass() {}

    public SchoolClass(String name, SchoolSubject subject, Teacher teacher, Term term, Period period, Classroom classroom) {
        this.name = name;
        this.subject = subject;
        this.teacher = teacher;
        this.term = term;
        this.period = period;
        this.classroom = classroom;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public SchoolSubject getSubject() { return subject; }

    public void setSubject(SchoolSubject subject) { this.subject = subject; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public Term getTerm() { return term; }

    public void setTerm(Term term) { this.term = term; }

    public Period getPeriod() { return period; }

    public void setPeriod(Period period) {}

    public Classroom getClassroom() { return classroom; }

    public void setClassroom(Classroom classroom) { this.classroom = classroom; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolClass)) return false;
        SchoolClass that = (SchoolClass) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", term=" + term +
                ", period=" + period +
                ", classroom=" + classroom +
                '}';
    }
}
