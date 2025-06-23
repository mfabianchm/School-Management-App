package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.Authentication.RegisterRequestDto;
import com.example.schoolManagementSystem.dtos.User.UserResponseDto;
import com.example.schoolManagementSystem.dtos.User.UserUpdateRequestDto;
import com.example.schoolManagementSystem.entities.Student;
import com.example.schoolManagementSystem.entities.User;
import com.example.schoolManagementSystem.enums.Role;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.repositories.StudentRepository;
import com.example.schoolManagementSystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername(), user.getRole(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return new UserResponseDto(user.getId(), user.getUsername(), user.getRole(), user.getEmail());
    }

    public UserResponseDto updateUser(Long id, UserUpdateRequestDto updateDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        // Check if email is unique if changed
        if (!user.getEmail().equals(updateDto.getEmail()) &&
                userRepository.existsByEmail(updateDto.getEmail())) {
            throw new IllegalArgumentException("Email is already taken");
        }

        user.setEmail(updateDto.getEmail());
        user.setRole(updateDto.getRole());

        User updatedUser = userRepository.save(user);

        return new UserResponseDto(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getRole(), updatedUser.getEmail());
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public User registerUser(RegisterRequestDto request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole() != null ? request.getRole() : Role.STUDENT
        );

        user = userRepository.save(user);

        // 3. If role is STUDENT, create a Student entity too
        if(user.getRole() == Role.STUDENT) {
            if (request.getDateOfBirth() == null || request.getGender() == null || request.getEnrolmentDate() == null) {
                throw new IllegalArgumentException("Missing student-specific fields: dateOfBirth, gender, or enrolmentDate");
            }

            Student student = new Student();
            student.setStudentFirstname(request.getFirstName());
            student.setStudentLastname(request.getLastName());
            student.setDateOfBirth(request.getDateOfBirth());
            student.setGender(request.getGender());
            student.setEnrolmentDate(request.getEnrolmentDate());
            student.setUser(user); // link user

            studentRepository.save(student);
        }

        return user;
    }
}
