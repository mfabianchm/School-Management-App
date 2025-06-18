package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "period_seq")
    @SequenceGenerator(name = "period_seq", sequenceName = "period_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "school_year_id", nullable = false)
    private SchoolYear schoolYear;

    @Column(name = "period_name", nullable = false)
    private String periodName;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    public Period() {}

    public Period(Long id, SchoolYear schoolYear, String periodName, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.schoolYear = schoolYear;
        this.periodName = periodName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(id, period.id) && Objects.equals(schoolYear, period.schoolYear) && Objects.equals(periodName, period.periodName) && Objects.equals(startTime, period.startTime) && Objects.equals(endTime, period.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolYear, periodName, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", schoolYear=" + schoolYear +
                ", periodName='" + periodName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
