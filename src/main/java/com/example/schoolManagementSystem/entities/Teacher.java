package com.example.schoolManagementSystem.entities;

import com.example.schoolManagementSystem.enums.Gender;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_seq")
    @SequenceGenerator(name = "teachers_seq", sequenceName = "teachers_seq", allocationSize = 1)
    private Long id;

    @Column(name = "teacher_firstname", nullable = false)
    private String teacherFirstname;

    @Column(name = "teacher_lasttname", nullable = false)
    private String teacherLastname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public Teacher() {}

    public Teacher(Long id, String teacherFirstname, String teacherLastname, Gender gender, String email, String phoneNumber) {
        this.id = id;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(teacherFirstname, teacher.teacherFirstname) && Objects.equals(teacherLastname, teacher.teacherLastname) && gender == teacher.gender && Objects.equals(email, teacher.email) && Objects.equals(phoneNumber, teacher.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherFirstname, teacherLastname, gender, email, phoneNumber);
    }

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
