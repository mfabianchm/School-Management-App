package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Department.DepartmentResponseDto;
import com.example.schoolManagementSystem.dtos.StudentGuardian.StudentGuardianRequestDto;
import com.example.schoolManagementSystem.dtos.StudentGuardian.StudentGuardianResponseDto;
import com.example.schoolManagementSystem.services.StudentGuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-guardians")
@PreAuthorize("hasRole('ADMIN')")
public class StudentGuardianController {
    private final StudentGuardianService studentGuardianService;

    public StudentGuardianController(StudentGuardianService studentGuardianService) {
        this.studentGuardianService = studentGuardianService;
    }

    @PostMapping
    public ResponseEntity<StudentGuardianResponseDto> create(@RequestBody StudentGuardianRequestDto dto) {
        return new ResponseEntity<>(studentGuardianService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentGuardianResponseDto> update(@PathVariable Long id,
                                                             @RequestBody StudentGuardianRequestDto dto) {
        return ResponseEntity.ok(studentGuardianService.update(id, dto));
    }

    @GetMapping
    public List<StudentGuardianResponseDto> getAll() {
        return studentGuardianService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentGuardianResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentGuardianService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentGuardianService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
