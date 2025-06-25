package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolYear.SchoolYearResponseDto;
import com.example.schoolManagementSystem.services.SchoolYearService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-years")
@PreAuthorize("hasRole('ADMIN')")
public class SchoolYearController {

    private final SchoolYearService service;

    public SchoolYearController(SchoolYearService service) {
        this.service = service;
    }

    @GetMapping
    public List<SchoolYearResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolYearResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<SchoolYearResponseDto> create(@Valid @RequestBody SchoolYearRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolYearResponseDto> update(@PathVariable Long id, @Valid @RequestBody SchoolYearRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
