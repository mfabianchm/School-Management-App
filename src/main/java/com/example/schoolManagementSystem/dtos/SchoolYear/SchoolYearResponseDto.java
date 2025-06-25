package com.example.schoolManagementSystem.dtos.SchoolYear;

import java.time.LocalDate;

public class SchoolYearResponseDto {
    private Long id;
    private String yearName;
    private LocalDate startDate;
    private LocalDate endDate;

    public SchoolYearResponseDto() {}

    public SchoolYearResponseDto(Long id, String yearName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.yearName = yearName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public String getYearName() {
        return yearName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
