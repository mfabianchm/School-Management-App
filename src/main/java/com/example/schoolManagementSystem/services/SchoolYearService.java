package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearResponseDto;
import com.example.schoolManagementSystem.entities.SchoolYear;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.SchoolYearMapper;
import com.example.schoolManagementSystem.repositories.SchoolYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolYearService {

    private final SchoolYearRepository repository;

    public SchoolYearService(SchoolYearRepository repository) {
        this.repository = repository;
    }

    public List<SchoolYearResponseDto> getAll() {
        return repository.findAll().stream()
                .map(SchoolYearMapper::toDto)
                .collect(Collectors.toList());
    }

    public SchoolYearResponseDto getById(Long id) {
        SchoolYear year = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School year not found"));
        return SchoolYearMapper.toDto(year);
    }

    public SchoolYearResponseDto create(SchoolYearRequestDto dto) {
        if (repository.existsByYearName(dto.getYearName())) {
            throw new IllegalArgumentException("School year already exists");
        }
        SchoolYear year = SchoolYearMapper.toEntity(dto);
        year = repository.save(year);
        return SchoolYearMapper.toDto(year);
    }

    public SchoolYearResponseDto update(Long id, SchoolYearRequestDto dto) {
        SchoolYear year = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School year not found"));
        SchoolYearMapper.updateEntity(year, dto);
        year = repository.save(year);
        return SchoolYearMapper.toDto(year);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("School year not found");
        }
        repository.deleteById(id);
    }
}
