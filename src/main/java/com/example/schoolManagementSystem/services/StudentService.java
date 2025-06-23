package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Student.StudentRequestDto;
import com.example.schoolManagementSystem.dtos.Student.StudentResponseDto;
import com.example.schoolManagementSystem.dtos.Student.StudentUpdateRequestDto;
import com.example.schoolManagementSystem.entities.Student;
import com.example.schoolManagementSystem.entities.User;
import com.example.schoolManagementSystem.enums.Role;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.StudentMapper;
import com.example.schoolManagementSystem.repositories.StudentRepository;
import com.example.schoolManagementSystem.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public StudentResponseDto createStudent(StudentRequestDto dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Create and save the User
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole() != null ? dto.getRole() : Role.STUDENT);

        user = userRepository.save(user);

        // Create and save the Student using the same User ID (via @MapsId)
        Student student = StudentMapper.toEntity(dto, user);

        student = studentRepository.save(student);
        return StudentMapper.toDto(student);

    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(StudentMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public StudentResponseDto updateStudent(Long id, StudentUpdateRequestDto dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        StudentMapper.updateEntity(student, dto);
        studentRepository.save(student);
        return StudentMapper.toDto(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        userRepository.delete(student.getUser());
        studentRepository.delete(student);
    }
}
