package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.ClassroomTypes;
import com.example.schoolManagementSystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomTypeRepository extends JpaRepository<ClassroomTypes, Long> {
}
