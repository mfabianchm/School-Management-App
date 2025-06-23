package com.example.schoolManagementSystem.entities;

import com.example.schoolManagementSystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    @Column(name = "student_firstname", nullable = false)
    private String studentFirstname;

    @Column(name = "student_lastname", nullable = false) // fixed typo here
    private String studentLastname;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "enrolment_date", nullable = false)
    private LocalDate enrolmentDate;


    public Student() {}

    public Student(User user, String studentFirstname, String studentLastname, LocalDate dateOfBirth, Gender gender, LocalDate enrolmentDate) {
        this.user = user;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrolmentDate = enrolmentDate;
    }


    public Long getId() {
        return id;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentFirstname='" + studentFirstname + '\'' +
                ", studentLastname='" + studentLastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", enrolmentDate=" + enrolmentDate +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }
}
