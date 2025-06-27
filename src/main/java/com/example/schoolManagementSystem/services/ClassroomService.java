package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Classroom.ClassroomRequestDto;
import com.example.schoolManagementSystem.dtos.Classroom.ClassroomResponseDto;
import com.example.schoolManagementSystem.entities.Classroom;
import com.example.schoolManagementSystem.entities.ClassroomTypes;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.ClassroomMapper;
import com.example.schoolManagementSystem.repositories.ClassroomRepository;
import com.example.schoolManagementSystem.repositories.ClassroomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final ClassroomTypeRepository classroomTypesRepository;

    public ClassroomService(ClassroomRepository classroomRepository, ClassroomTypeRepository classroomTypesRepository) {
        this.classroomRepository = classroomRepository;
        this.classroomTypesRepository = classroomTypesRepository;
    }

    public List<ClassroomResponseDto> getAll() {
        return classroomRepository.findAll().stream()
                .map(ClassroomMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClassroomResponseDto getById(Long id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));
        return ClassroomMapper.toDto(classroom);
    }

    public ClassroomResponseDto create(ClassroomRequestDto dto) {
        ClassroomTypes type = classroomTypesRepository.findById(dto.getClassroomTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("ClassroomType not found"));

        Classroom classroom = ClassroomMapper.toEntity(dto, type);
        classroom = classroomRepository.save(classroom);
        return ClassroomMapper.toDto(classroom);
    }

    public ClassroomResponseDto update(Long id, ClassroomRequestDto dto) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));

        ClassroomTypes type = classroomTypesRepository.findById(dto.getClassroomTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("ClassroomType not found"));

        ClassroomMapper.updateEntity(classroom, dto, type);
        classroom = classroomRepository.save(classroom);
        return ClassroomMapper.toDto(classroom);
    }

    public void delete(Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Classroom not found");
        }
        classroomRepository.deleteById(id);
    }
}
