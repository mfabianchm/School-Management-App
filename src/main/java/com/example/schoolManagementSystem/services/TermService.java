package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Term.TermRequestDto;
import com.example.schoolManagementSystem.dtos.Term.TermResponseDto;
import com.example.schoolManagementSystem.entities.SchoolYear;
import com.example.schoolManagementSystem.entities.Term;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.TermMapper;
import com.example.schoolManagementSystem.repositories.SchoolYearRepository;
import com.example.schoolManagementSystem.repositories.TermRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TermService {

    private final TermRepository termRepository;
    private final SchoolYearRepository schoolYearRepository;

    public TermService(TermRepository termRepository, SchoolYearRepository schoolYearRepository) {
        this.termRepository = termRepository;
        this.schoolYearRepository = schoolYearRepository;
    }

    public List<TermResponseDto> getAll() {
        return termRepository.findAll().stream()
                .map(TermMapper::toDto)
                .collect(Collectors.toList());
    }

    public TermResponseDto getById(Long id) {
        Term term = termRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Term not found"));
        return TermMapper.toDto(term);
    }

    public TermResponseDto create(TermRequestDto dto) {
        SchoolYear schoolYear = schoolYearRepository.findById(dto.getSchoolYearId())
                .orElseThrow(() -> new ResourceNotFoundException("SchoolYear not found"));

        Term term = TermMapper.toEntity(dto, schoolYear);
        term = termRepository.save(term);
        return TermMapper.toDto(term);
    }

    public TermResponseDto update(Long id, TermRequestDto dto) {
        Term term = termRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Term not found"));

        SchoolYear schoolYear = schoolYearRepository.findById(dto.getSchoolYearId())
                .orElseThrow(() -> new ResourceNotFoundException("SchoolYear not found"));

        TermMapper.updateEntity(term, dto, schoolYear);
        term = termRepository.save(term);
        return TermMapper.toDto(term);
    }

    public void delete(Long id) {
        if (!termRepository.existsById(id)) {
            throw new ResourceNotFoundException("Term not found");
        }
        termRepository.deleteById(id);
    }
}
