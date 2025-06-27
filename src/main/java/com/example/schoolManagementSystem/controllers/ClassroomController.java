package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Classroom.ClassroomRequestDto;
import com.example.schoolManagementSystem.dtos.Classroom.ClassroomResponseDto;
import com.example.schoolManagementSystem.services.ClassroomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
@PreAuthorize("hasRole('ADMIN')")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public List<ClassroomResponseDto> getAll() {
        return classroomService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClassroomResponseDto> create(@Valid @RequestBody ClassroomRequestDto dto) {
        return new ResponseEntity<>(classroomService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomResponseDto> update(@PathVariable Long id,
                                                       @Valid @RequestBody ClassroomRequestDto dto) {
        return ResponseEntity.ok(classroomService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classroomService.delete(id);
        return ResponseEntity.noContent().build();
    }
}