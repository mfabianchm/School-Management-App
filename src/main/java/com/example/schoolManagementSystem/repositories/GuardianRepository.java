package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    boolean existsByEmail(String email);
}

