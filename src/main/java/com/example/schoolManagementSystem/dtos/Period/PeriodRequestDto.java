package com.example.schoolManagementSystem.dtos.Period;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class PeriodRequestDto {

    @NotBlank
    private String periodName;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private Long schoolYearId;

    public PeriodRequestDto() {}

    public PeriodRequestDto(String periodName, LocalTime startTime, LocalTime endTime, Long schoolYearId) {
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schoolYearId = schoolYearId;
    }

    public @NotBlank String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(@NotBlank String periodName) {
        this.periodName = periodName;
    }

    public @NotNull LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NotNull LocalTime startTime) {
        this.startTime = startTime;
    }

    public @NotNull LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(@NotNull LocalTime endTime) {
        this.endTime = endTime;
    }

    public @NotNull Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(@NotNull Long schoolYearId) {
        this.schoolYearId = schoolYearId;
    }
}