package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Guardian.GuardianRequestDto;
import com.example.schoolManagementSystem.dtos.Guardian.GuardianResponseDto;
import com.example.schoolManagementSystem.services.GuardianService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardians")
@PreAuthorize("hasRole('ADMIN')")
public class GuardianController {
    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @PostMapping
    public ResponseEntity<GuardianResponseDto> create(@Valid @RequestBody GuardianRequestDto dto) {
        return new ResponseEntity<>(guardianService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardianResponseDto> update(@PathVariable Long id,
                                                      @Valid @RequestBody GuardianRequestDto dto) {
        return ResponseEntity.ok(guardianService.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardianResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(guardianService.getById(id));
    }

    @GetMapping
    public List<GuardianResponseDto> getAll() {
        return guardianService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guardianService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
