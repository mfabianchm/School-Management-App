package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.SchoolClass.SchoolClassRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolClass.SchoolClassResponseDto;
import com.example.schoolManagementSystem.services.SchoolClassService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-class")
@PreAuthorize("hasRole('ADMIN')")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<List<SchoolClassResponseDto>> getAllSchoolClasses() {
        return ResponseEntity.ok(schoolClassService.getAllSchoolClasses());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public ResponseEntity<SchoolClassResponseDto> getSchoolClassById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolClassService.getSchoolClassById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createSchoolClass(@RequestBody @Valid SchoolClassRequestDto dto) {
        try {
            SchoolClassResponseDto response = schoolClassService.create(dto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SchoolClassResponseDto> updateSchoolClass(@PathVariable Long id, @RequestBody @Valid SchoolClassRequestDto dto) {
        return ResponseEntity.ok(schoolClassService.updateSchoolClass(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        schoolClassService.delete(id);
        return ResponseEntity.ok("SchoolClass deleted successfully");
    }



}
