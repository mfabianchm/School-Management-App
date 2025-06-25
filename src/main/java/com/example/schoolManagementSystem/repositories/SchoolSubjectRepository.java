package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.SchoolSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, Long> {
}
