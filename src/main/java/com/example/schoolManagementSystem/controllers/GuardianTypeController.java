package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeRequestDto;
import com.example.schoolManagementSystem.dtos.GuardianType.GuardianTypeResponseDto;
import com.example.schoolManagementSystem.entities.GuardianType;
import com.example.schoolManagementSystem.services.GuardianTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guardian-types")
@PreAuthorize("hasRole('ADMIN')")
public class GuardianTypeController {

    private final GuardianTypeService guardianTypeService;

    public GuardianTypeController(GuardianTypeService guardianTypeService) {
        this.guardianTypeService = guardianTypeService;
    }

    @PostMapping
    public ResponseEntity<GuardianTypeResponseDto> create(@Valid @RequestBody GuardianTypeRequestDto dto) {
        GuardianTypeResponseDto response = guardianTypeService.create(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GuardianTypeResponseDto>> getAll() {
        List<GuardianTypeResponseDto> types = guardianTypeService.getAll();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardianTypeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(guardianTypeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuardianTypeResponseDto> update(@PathVariable Long id,
                                                          @Valid @RequestBody GuardianTypeRequestDto dto) {
        GuardianTypeResponseDto updated = guardianTypeService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guardianTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
