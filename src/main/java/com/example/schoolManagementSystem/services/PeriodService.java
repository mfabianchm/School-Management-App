package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Period.PeriodRequestDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodResponseDto;
import com.example.schoolManagementSystem.entities.Period;
import com.example.schoolManagementSystem.entities.SchoolYear;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.PeriodMapper;
import com.example.schoolManagementSystem.repositories.PeriodRepository;
import com.example.schoolManagementSystem.repositories.SchoolYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodService {

    private final PeriodRepository periodRepository;
    private final SchoolYearRepository schoolYearRepository;

    public PeriodService(PeriodRepository periodRepository, SchoolYearRepository schoolYearRepository) {
        this.periodRepository = periodRepository;
        this.schoolYearRepository = schoolYearRepository;
    }

    public List<PeriodResponseDto> getAll() {
        return periodRepository.findAll()
                .stream()
                .map(PeriodMapper::toDto)
                .collect(Collectors.toList());
    }

    public PeriodResponseDto getById(Long id) {
        Period period = periodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Period not found"));
        return PeriodMapper.toDto(period);
    }

    public PeriodResponseDto create(PeriodRequestDto dto) {
        SchoolYear schoolYear = schoolYearRepository.findById(dto.getSchoolYearId())
                .orElseThrow(() -> new ResourceNotFoundException("School year not found"));

        Period period = PeriodMapper.toEntity(dto, schoolYear);
        period = periodRepository.save(period);
        return PeriodMapper.toDto(period);
    }

    public PeriodResponseDto update(Long id, PeriodRequestDto dto) {
        Period period = periodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Period not found"));

        SchoolYear schoolYear = schoolYearRepository.findById(dto.getSchoolYearId())
                .orElseThrow(() -> new ResourceNotFoundException("School year not found"));

        PeriodMapper.updateEntity(period, dto, schoolYear);
        period = periodRepository.save(period);
        return PeriodMapper.toDto(period);
    }

    public void delete(Long id) {
        if (!periodRepository.existsById(id)) {
            throw new ResourceNotFoundException("Period not found");
        }
        periodRepository.deleteById(id);
    }
}