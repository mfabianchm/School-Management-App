package com.example.schoolManagementSystem.entities;

import com.example.schoolManagementSystem.enums.Gender;
import com.example.schoolManagementSystem.enums.Grades;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "score_ranges")
public class ScoreRange {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_range_seq")
    @SequenceGenerator(name = "score_range_seq", sequenceName = "score_range_seq", allocationSize = 1)
    private Long id;

    @Column(name = "min_score", nullable = false)
    private Integer minScore;

    @Column(name = "max_score", nullable = false)
    private Integer maxScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grades grade;

    public ScoreRange() {}

    public ScoreRange(Long id, Integer maxScore, Integer minScore, Grades grade) {
        this.id = id;
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ScoreRange that = (ScoreRange) o;
        return Objects.equals(id, that.id) && Objects.equals(minScore, that.minScore) && Objects.equals(maxScore, that.maxScore) && grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minScore, maxScore, grade);
    }

    @Override
    public String toString() {
        return "ScoreRange{" +
                "id=" + id +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                ", grade=" + grade +
                '}';
    }
}
