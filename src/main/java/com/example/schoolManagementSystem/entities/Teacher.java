package com.example.schoolManagementSystem.entities;

import com.example.schoolManagementSystem.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    @Column(name = "teacher_firstname", nullable = false)
    private String teacherFirstname;

    @Column(name = "teacher_lastname", nullable = false)
    private String teacherLastname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public Teacher() {}

    public Teacher(User user, String teacherFirstname, String teacherLastname, Gender gender, String email, String phoneNumber) {
        this.user = user;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    // Getters and setters...

    public Long getId() {
        return id;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // equals and hashCode based on id only

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString with all fields except relations

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherFirstname='" + teacherFirstname + '\'' +
                ", teacherLastname='" + teacherLastname + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}