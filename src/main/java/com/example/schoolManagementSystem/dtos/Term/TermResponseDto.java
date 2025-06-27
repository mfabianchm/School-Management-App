package com.example.schoolManagementSystem.dtos.Term;

import java.time.LocalDate;

public class TermResponseDto {
    private Long id;
    private Integer termNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long schoolYearId;

    public TermResponseDto(Long id, Integer termNumber, LocalDate startDate, LocalDate endDate, Long schoolYearId) {
        this.id = id;
        this.termNumber = termNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schoolYearId = schoolYearId;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Integer getTermNumber() {
        return termNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getSchoolYearId() {
        return schoolYearId;
    }
}
