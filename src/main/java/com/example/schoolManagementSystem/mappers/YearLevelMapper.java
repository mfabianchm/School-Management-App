package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelRequestDto;
import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelResponseDto;
import com.example.schoolManagementSystem.entities.YearLevel;

public class YearLevelMapper {
    public static YearLevel toEntity(YearLevelRequestDto dto) {
        YearLevel yearLevel = new YearLevel();
        yearLevel.setLevelName(dto.getLevelName());
        yearLevel.setLevelOrder(dto.getLevelOrder());
        return yearLevel;
    }

    public static void updateEntity(YearLevel yearLevel, YearLevelRequestDto dto) {
        yearLevel.setLevelName(dto.getLevelName());
        yearLevel.setLevelOrder(dto.getLevelOrder());
    }

    public static YearLevelResponseDto toDto(YearLevel entity) {
        return new YearLevelResponseDto(entity.getId(), entity.getLevelName(), entity.getLevelOrder());
    }
}
