package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Teachers.TeacherRequestDto;
import com.example.schoolManagementSystem.dtos.Teachers.TeacherResponseDto;
import com.example.schoolManagementSystem.entities.Teacher;
import com.example.schoolManagementSystem.entities.User;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.TeacherMapper;
import com.example.schoolManagementSystem.repositories.TeacherRepository;
import com.example.schoolManagementSystem.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TeacherService(TeacherRepository teacherRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public TeacherResponseDto createTeacher(TeacherRequestDto dto) {

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }


        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        user = userRepository.save(user);


        Teacher teacher = TeacherMapper.toEntity(dto, user);
        teacher = teacherRepository.save(teacher);

        return TeacherMapper.toDto(teacher);
    }

    public List<TeacherResponseDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(TeacherMapper::toDto)
                .collect(Collectors.toList());
    }

    public TeacherResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
        return TeacherMapper.toDto(teacher);
    }

    public TeacherResponseDto updateTeacher(Long id, TeacherRequestDto dto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        TeacherMapper.updateEntity(teacher, dto);
        teacher = teacherRepository.save(teacher);

        return TeacherMapper.toDto(teacher);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        teacherRepository.delete(teacher);
        userRepository.delete(teacher.getUser());
    }

    public boolean isOwner(Long teacherId, String username) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> teacher.getUser().getUsername().equals(username))
                .orElse(false);
    }

}
