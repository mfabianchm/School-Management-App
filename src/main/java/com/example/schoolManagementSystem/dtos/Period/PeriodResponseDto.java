package com.example.schoolManagementSystem.dtos.Period;

import java.time.LocalTime;

public class PeriodResponseDto {
    private Long id;
    private String periodName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long schoolYearId;

    public PeriodResponseDto() {}

    public PeriodResponseDto(Long id, String periodName, LocalTime startTime, LocalTime endTime, Long schoolYearId) {
        this.id = id;
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schoolYearId = schoolYearId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Long schoolYearId) {
        this.schoolYearId = schoolYearId;
    }
}
