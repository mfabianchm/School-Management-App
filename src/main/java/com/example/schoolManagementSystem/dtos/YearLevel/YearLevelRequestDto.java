package com.example.schoolManagementSystem.dtos.YearLevel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class YearLevelRequestDto {
    @NotBlank
    private String levelName;

    @NotNull
    @Min(1)
    private Integer levelOrder;

    public YearLevelRequestDto() {
    }

    public YearLevelRequestDto(String levelName, Integer levelOrder) {
        this.levelName = levelName;
        this.levelOrder = levelOrder;
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
}
