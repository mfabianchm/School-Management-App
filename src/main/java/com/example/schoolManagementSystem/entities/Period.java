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

    // Getters and Setters
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

    // equals and hashCode using only ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;
        Period period = (Period) o;
        return Objects.equals(id, period.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString for debugging
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
