package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelRequestDto;
import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelResponseDto;
import com.example.schoolManagementSystem.entities.YearLevel;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.YearLevelMapper;
import com.example.schoolManagementSystem.repositories.YearLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YearLevelService {

    private final YearLevelRepository repository;

    public YearLevelService(YearLevelRepository repository) {
        this.repository = repository;
    }

    public List<YearLevelResponseDto> getAll() {
        return repository.findAll().stream()
                .map(YearLevelMapper::toDto)
                .collect(Collectors.toList());
    }

    public YearLevelResponseDto getById(Long id) {
        YearLevel yearLevel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Year level not found"));
        return YearLevelMapper.toDto(yearLevel);
    }

    public YearLevelResponseDto create(YearLevelRequestDto dto) {
        if (repository.existsByLevelName(dto.getLevelName())) {
            throw new IllegalArgumentException("Year level already exists");
        }
        YearLevel yearLevel = YearLevelMapper.toEntity(dto);
        yearLevel = repository.save(yearLevel);
        return YearLevelMapper.toDto(yearLevel);
    }

    public YearLevelResponseDto update(Long id, YearLevelRequestDto dto) {
        YearLevel yearLevel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Year level not found"));
        YearLevelMapper.updateEntity(yearLevel, dto);
        yearLevel = repository.save(yearLevel);
        return YearLevelMapper.toDto(yearLevel);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Year level not found");
        }
        repository.deleteById(id);
    }
}
