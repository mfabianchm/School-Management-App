package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {}
