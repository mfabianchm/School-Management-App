package com.example.schoolManagementSystem.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "year_level")
public class YearLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "year_level_seq")
    @SequenceGenerator(name = "year_level_seq", sequenceName = "year_level_seq", allocationSize = 1)
    private Long id;

    @Column(name = "level_name", nullable = false)
    private String levelName;

    @Column(name = "level_order", nullable = false)
    private Integer levelOrder;

    public YearLevel() {}

    public YearLevel(Long id, String levelName, Integer levelOrder) {
        this.id = id;
        this.levelName = levelName;
        this.levelOrder = levelOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelOrder() {
        return levelOrder;
    }

    public void setLevelOrder(Integer levelOrder) {
        this.levelOrder = levelOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        YearLevel yearLevel = (YearLevel) o;
        return Objects.equals(id, yearLevel.id) && Objects.equals(levelName, yearLevel.levelName) && Objects.equals(levelOrder, yearLevel.levelOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, levelName, levelOrder);
    }

    @Override
    public String toString() {
        return "YearLevel{" +
                "id=" + id +
                ", levelName='" + levelName + '\'' +
                ", levelOrder=" + levelOrder +
                '}';
    }
}
