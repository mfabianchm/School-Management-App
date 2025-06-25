package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByDepartmentName(String name);
}
