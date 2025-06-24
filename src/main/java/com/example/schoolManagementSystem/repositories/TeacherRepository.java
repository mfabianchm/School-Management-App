package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Student;
import com.example.schoolManagementSystem.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {}