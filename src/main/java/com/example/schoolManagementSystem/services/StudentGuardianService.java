package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.StudentGuardian.StudentGuardianRequestDto;
import com.example.schoolManagementSystem.dtos.StudentGuardian.StudentGuardianResponseDto;
import com.example.schoolManagementSystem.entities.Guardian;
import com.example.schoolManagementSystem.entities.GuardianType;
import com.example.schoolManagementSystem.entities.Student;
import com.example.schoolManagementSystem.entities.StudentGuardian;
import com.example.schoolManagementSystem.mappers.StudentGuardianMapper;
import com.example.schoolManagementSystem.repositories.GuardianRepository;
import com.example.schoolManagementSystem.repositories.GuardianTypeRepository;
import com.example.schoolManagementSystem.repositories.StudentGuardianRepository;
import com.example.schoolManagementSystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentGuardianService {
    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final GuardianTypeRepository guardianTypeRepository;
    private final StudentGuardianRepository studentGuardianRepository;

    public StudentGuardianService(StudentRepository studentRepository,
                                  GuardianRepository guardianRepository,
                                  GuardianTypeRepository guardianTypeRepository,
                                  StudentGuardianRepository studentGuardianRepository) {
        this.studentRepository = studentRepository;
        this.guardianRepository = guardianRepository;
        this.guardianTypeRepository = guardianTypeRepository;
        this.studentGuardianRepository = studentGuardianRepository;
    }

    public StudentGuardianResponseDto create(StudentGuardianRequestDto dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Guardian guardian = guardianRepository.findById(dto.getGuardianId())
                .orElseThrow(() -> new RuntimeException("Guardian not found"));
        GuardianType type = guardianTypeRepository.findById(dto.getGuardianTypeId())
                .orElseThrow(() -> new RuntimeException("GuardianType not found"));

        StudentGuardian sg = new StudentGuardian(student, guardian, type);
        StudentGuardian saved = studentGuardianRepository.save(sg);
        return StudentGuardianMapper.toDto(saved);
    }

    public StudentGuardianResponseDto update(Long id, StudentGuardianRequestDto dto) {
        StudentGuardian existing = studentGuardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentGuardian not found"));

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Guardian guardian = guardianRepository.findById(dto.getGuardianId())
                .orElseThrow(() -> new RuntimeException("Guardian not found"));
        GuardianType type = guardianTypeRepository.findById(dto.getGuardianTypeId())
                .orElseThrow(() -> new RuntimeException("GuardianType not found"));

        existing.setStudent(student);
        existing.setGuardian(guardian);
        existing.setGuardianType(type);

        StudentGuardian updated = studentGuardianRepository.save(existing);
        return StudentGuardianMapper.toDto(updated);
    }

    public List<StudentGuardianResponseDto> getAll() {
        return studentGuardianRepository.findAll().stream()
                .map(StudentGuardianMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentGuardianResponseDto getById(Long id) {
        StudentGuardian studentGuardian = studentGuardianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentGuardian not found with id: " + id));

        return StudentGuardianMapper.toDto(studentGuardian);
    }

    public void delete(Long id) {
        studentGuardianRepository.deleteById(id);
    }
}

