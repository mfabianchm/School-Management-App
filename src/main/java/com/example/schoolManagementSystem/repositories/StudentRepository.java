package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}