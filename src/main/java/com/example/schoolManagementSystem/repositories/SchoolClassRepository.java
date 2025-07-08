package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    boolean existsByName(String name);
}
