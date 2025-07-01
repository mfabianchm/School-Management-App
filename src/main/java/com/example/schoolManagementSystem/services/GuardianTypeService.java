package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeRequestDto;
import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeResponseDto;
import com.example.schoolManagementSystem.entities.GuardianType;
import com.example.schoolManagementSystem.enums.GuardianTypes;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.GuardianTypeMapper;
import com.example.schoolManagementSystem.repositories.GuardianTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardianTypeService {

    private final GuardianTypeRepository guardianTypeRepository;

    public GuardianTypeService(GuardianTypeRepository guardianTypeRepository) {
        this.guardianTypeRepository = guardianTypeRepository;
    }

    public GuardianTypeResponseDto create(GuardianTypeRequestDto dto) {
        GuardianTypes type;

        try {
            type = GuardianTypes.valueOf(dto.getGuardianType().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid guardian type: " + dto.getGuardianType());
        }

        GuardianType guardianType = new GuardianType();
        guardianType.setGuardianType(type);

        GuardianType saved = guardianTypeRepository.save(guardianType);
        return GuardianTypeMapper.toDto(saved);
    }


    public List<GuardianTypeResponseDto> getAll() {
        return guardianTypeRepository.findAll().stream()
                .map(GuardianTypeMapper::toDto)
                .collect(Collectors.toList());
    }


    public GuardianTypeResponseDto getById(Long id) {
        GuardianType guardianType = guardianTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GuardianType not found"));
        return GuardianTypeMapper.toDto(guardianType);
    }


    public GuardianTypeResponseDto update(Long id, GuardianTypeRequestDto dto) {
        GuardianType guardianType = guardianTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GuardianType not found"));

        try {
            GuardianTypes type = GuardianTypes.valueOf(dto.getGuardianType().toUpperCase());
            guardianType.setGuardianType(type);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid guardian type: " + dto.getGuardianType());
        }

        GuardianType updated = guardianTypeRepository.save(guardianType);
        return GuardianTypeMapper.toDto(updated);
    }


    public void delete(Long id) {
        if (!guardianTypeRepository.existsById(id)) {
            throw new RuntimeException("GuardianType not found");
        }
        guardianTypeRepository.deleteById(id);
    }


}
