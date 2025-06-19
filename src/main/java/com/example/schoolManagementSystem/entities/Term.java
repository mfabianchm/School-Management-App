package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terms_seq")
    @SequenceGenerator(name = "terms_seq", sequenceName = "terms_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "year_id", nullable = false)
    private SchoolYear schoolYear;

    @Column(name = "term_number", nullable = false)
    private Integer termNumber;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    public Term() {}

    public Term(Long id, SchoolYear schoolYear, Integer termNumber, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.schoolYear = schoolYear;
        this.termNumber = termNumber;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return Objects.equals(id, term.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", schoolYearId=" + (schoolYear != null ? schoolYear.getId() : null) +
                ", termNumber=" + termNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
