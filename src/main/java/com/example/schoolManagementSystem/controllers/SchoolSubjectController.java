package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolSubject.SchoolSubjectResponseDto;
import com.example.schoolManagementSystem.services.SchoolSubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@PreAuthorize("hasRole('ADMIN')")
public class SchoolSubjectController {

    private final SchoolSubjectService subjectService;

    public SchoolSubjectController(SchoolSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SchoolSubjectResponseDto> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolSubjectResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SchoolSubjectResponseDto> create(@Valid @RequestBody SchoolSubjectRequestDto dto) {
        return new ResponseEntity<>(subjectService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolSubjectResponseDto> update(@PathVariable Long id,
                                                           @Valid @RequestBody SchoolSubjectRequestDto dto) {
        return ResponseEntity.ok(subjectService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subjectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
