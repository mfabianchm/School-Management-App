package com.example.schoolManagementSystem.dtos.Term;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TermRequestDto {
    @NotNull
    private Long schoolYearId;

    @NotNull
    private Integer termNumber;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    // Getters and setters

    public Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Long schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public Integer getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(Integer termNumber) {
        this.termNumber = termNumber;
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
