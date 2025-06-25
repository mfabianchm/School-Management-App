package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Department.DepartmentRequestDto;
import com.example.schoolManagementSystem.dtos.Department.DepartmentResponseDto;
import com.example.schoolManagementSystem.entities.Department;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.DepartmentMapper;
import com.example.schoolManagementSystem.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public DepartmentResponseDto getById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return DepartmentMapper.toDto(department);
    }

    public DepartmentResponseDto create(DepartmentRequestDto dto) {
        if (departmentRepository.existsByDepartmentName(dto.getDepartmentName())) {
            throw new IllegalArgumentException("Department name already exists");
        }

        Department department = DepartmentMapper.toEntity(dto);
        department = departmentRepository.save(department);
        return DepartmentMapper.toDto(department);
    }

    public DepartmentResponseDto update(Long id, DepartmentRequestDto dto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        DepartmentMapper.updateEntity(department, dto);
        department = departmentRepository.save(department);
        return DepartmentMapper.toDto(department);
    }

    public void delete(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found");
        }
        departmentRepository.deleteById(id);
    }
}
