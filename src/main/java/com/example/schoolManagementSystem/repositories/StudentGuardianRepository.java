package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.StudentGuardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentGuardianRepository extends JpaRepository<StudentGuardian, Long> {
    List<StudentGuardian> findByStudentId(Long studentId);
    List<StudentGuardian> findByGuardianId(Long guardianId);
}
