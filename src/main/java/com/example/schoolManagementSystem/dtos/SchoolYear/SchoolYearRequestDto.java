package com.example.schoolManagementSystem.dtos.SchoolYear;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SchoolYearRequestDto {
    @NotBlank
    private String yearName;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public SchoolYearRequestDto() {}

    public SchoolYearRequestDto(String yearName, LocalDate startDate, LocalDate endDate) {
        this.yearName = yearName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
