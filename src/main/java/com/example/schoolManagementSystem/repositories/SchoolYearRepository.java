package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
    boolean existsByYearName(String yearName);
}
