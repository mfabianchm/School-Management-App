package com.example.schoolManagementSystem.repositories;

import com.example.schoolManagementSystem.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

}
