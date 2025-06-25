package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelRequestDto;
import com.example.schoolManagementSystem.dtos.YearLevel.YearLevelResponseDto;
import com.example.schoolManagementSystem.services.YearLevelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/year-levels")
@PreAuthorize("hasRole('ADMIN')")
public class YearLevelController {

    private final YearLevelService service;

    public YearLevelController(YearLevelService service) {
        this.service = service;
    }

    @GetMapping
    public List<YearLevelResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<YearLevelResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<YearLevelResponseDto> create(@Valid @RequestBody YearLevelRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<YearLevelResponseDto> update(@PathVariable Long id, @Valid @RequestBody YearLevelRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
