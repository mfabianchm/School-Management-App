package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Guardian.GuardianRequestDto;
import com.example.schoolManagementSystem.dtos.Guardian.GuardianResponseDto;
import com.example.schoolManagementSystem.entities.Guardian;
import com.example.schoolManagementSystem.mappers.GuardianMapper;
import com.example.schoolManagementSystem.repositories.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianService {
    private final GuardianRepository guardianRepository;

    public GuardianService(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    public GuardianResponseDto create(GuardianRequestDto dto) {
        if (guardianRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        Guardian guardian = GuardianMapper.toEntity(dto);
        guardian = guardianRepository.save(guardian);
        return GuardianMapper.toDto(guardian);
    }

    public GuardianResponseDto update(Long id, GuardianRequestDto dto) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guardian not found"));

        GuardianMapper.updateEntity(guardian, dto);
        guardian = guardianRepository.save(guardian);
        return GuardianMapper.toDto(guardian);
    }

    public GuardianResponseDto getById(Long id) {
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guardian not found"));
        return GuardianMapper.toDto(guardian);
    }

    public List<GuardianResponseDto> getAll() {
        return guardianRepository.findAll()
                .stream()
                .map(GuardianMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!guardianRepository.existsById(id)) {
            throw new RuntimeException("Guardian not found");
        }
        guardianRepository.deleteById(id);
    }
}
