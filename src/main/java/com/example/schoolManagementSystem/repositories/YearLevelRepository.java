package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.YearLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearLevelRepository extends JpaRepository<YearLevel, Long> {
    boolean existsByLevelName(String levelName);
}
