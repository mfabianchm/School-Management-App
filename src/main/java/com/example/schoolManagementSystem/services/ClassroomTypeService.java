package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeRequestDto;
import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeResponseDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodRequestDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodResponseDto;
import com.example.schoolManagementSystem.entities.ClassroomTypes;
import com.example.schoolManagementSystem.entities.Period;
import com.example.schoolManagementSystem.entities.SchoolYear;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.ClassroomTypeMapper;
import com.example.schoolManagementSystem.mappers.PeriodMapper;
import com.example.schoolManagementSystem.repositories.ClassroomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomTypeService {

    private final ClassroomTypeRepository classroomTypeRepository;

    public ClassroomTypeService(ClassroomTypeRepository classroomTypeRepository) {
        this.classroomTypeRepository = classroomTypeRepository;
    }

    public List<ClassroomTypeResponseDto> getAll() {
        return classroomTypeRepository.findAll()
                .stream()
                .map(ClassroomTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClassroomTypeResponseDto getById(Long id) {
        ClassroomTypes classroomTypes = classroomTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom type not found"));
        return ClassroomTypeMapper.toDto(classroomTypes);
    }

    public ClassroomTypeResponseDto create(ClassroomTypeRequestDto dto) {
        ClassroomTypes classroomTypes = ClassroomTypeMapper.toEntity(dto);
        classroomTypes = classroomTypeRepository.save(classroomTypes);
        return ClassroomTypeMapper.toDto(classroomTypes);
    }

    public ClassroomTypeResponseDto update(Long id, ClassroomTypeRequestDto dto) {
        ClassroomTypes classroomTypes = classroomTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClassroomType not found"));


        ClassroomTypeMapper.updateEntity(classroomTypes, dto);
        classroomTypes = classroomTypeRepository.save(classroomTypes);
        return ClassroomTypeMapper.toDto(classroomTypes);
    }

    public void delete(Long id) {
        if (!classroomTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("ClassroomType not found");
        }
        classroomTypeRepository.deleteById(id);
    }
}
