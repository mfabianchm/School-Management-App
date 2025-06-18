package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "school_years")
public class SchoolYear {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school-year_seq")
    @SequenceGenerator(name = "school-year_seq", sequenceName = "school-year_seq", allocationSize = 1)
    private Long id;

    @Column(name = "year_name", nullable = false)
    private String yearName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;


    public SchoolYear() {}

    public SchoolYear(Long id, String yearName, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.yearName = yearName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SchoolYear that = (SchoolYear) o;
        return Objects.equals(id, that.id) && Objects.equals(yearName, that.yearName) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearName, startDate, endDate);
    }

    @Override
    public String toString() {
        return "SchoolYear{" +
                "id=" + id +
                ", yearName='" + yearName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
