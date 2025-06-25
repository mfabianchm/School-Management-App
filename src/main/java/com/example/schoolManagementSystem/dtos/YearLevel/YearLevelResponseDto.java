package com.example.schoolManagementSystem.dtos.YearLevel;

public class YearLevelResponseDto {
    private Long id;
    private String levelName;
    private Integer levelOrder;

    public YearLevelResponseDto() {
    }

    public YearLevelResponseDto(Long id, String levelName, Integer levelOrder) {
        this.id = id;
        this.levelName = levelName;
        this.levelOrder = levelOrder;
    }

    public Long getId() {
        return id;
    }

    public String getLevelName() {
        return levelName;
    }

    public Integer getLevelOrder() {
        return levelOrder;
    }
}
