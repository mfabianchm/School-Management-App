package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectResponseDto;
import com.example.schoolManagementSystem.entities.Department;
import com.example.schoolManagementSystem.entities.SchoolSubject;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.SchoolSubjectMapper;
import com.example.schoolManagementSystem.repositories.DepartmentRepository;
import com.example.schoolManagementSystem.repositories.SchoolSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolSubjectService {

    private final SchoolSubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;

    public SchoolSubjectService(SchoolSubjectRepository subjectRepository, DepartmentRepository departmentRepository) {
        this.subjectRepository = subjectRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<SchoolSubjectResponseDto> getAll() {
        return subjectRepository.findAll()
                .stream()
                .map(SchoolSubjectMapper::toDto)
                .collect(Collectors.toList());
    }

    public SchoolSubjectResponseDto getById(Long id) {
        SchoolSubject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        return SchoolSubjectMapper.toDto(subject);
    }

    public SchoolSubjectResponseDto create(SchoolSubjectRequestDto dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        SchoolSubject subject = SchoolSubjectMapper.toEntity(dto, department);
        subject = subjectRepository.save(subject);
        return SchoolSubjectMapper.toDto(subject);
    }

    public SchoolSubjectResponseDto update(Long id, SchoolSubjectRequestDto dto) {
        SchoolSubject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        SchoolSubjectMapper.updateEntity(subject, dto, department);
        subject = subjectRepository.save(subject);
        return SchoolSubjectMapper.toDto(subject);
    }

    public void delete(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found");
        }
        subjectRepository.deleteById(id);
    }
}
