package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Classroom.ClassroomResponseDto;
import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeRequestDto;
import com.example.schoolManagementSystem.dtos.ClassroomType.ClassroomTypeResponseDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodRequestDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodResponseDto;
import com.example.schoolManagementSystem.services.ClassroomTypeService;
import com.example.schoolManagementSystem.services.PeriodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom-types")
@PreAuthorize("hasRole('ADMIN')")
public class ClassRoomTypeController {
    private final ClassroomTypeService classroomTypeService;

    public ClassRoomTypeController(ClassroomTypeService classroomTypeService) {
        this.classroomTypeService = classroomTypeService;
    }

    @GetMapping
    public List<ClassroomTypeResponseDto> getAll() {
        return classroomTypeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomTypeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomTypeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ClassroomTypeResponseDto> create(@Valid @RequestBody ClassroomTypeRequestDto dto) {
        return new ResponseEntity<>(classroomTypeService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomTypeResponseDto> update(@PathVariable Long id, @Valid @RequestBody ClassroomTypeRequestDto dto) {
        return ResponseEntity.ok(classroomTypeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classroomTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
