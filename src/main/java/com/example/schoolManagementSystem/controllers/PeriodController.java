package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Period.PeriodRequestDto;
import com.example.schoolManagementSystem.dtos.Period.PeriodResponseDto;
import com.example.schoolManagementSystem.services.PeriodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
@PreAuthorize("hasRole('ADMIN')")
public class PeriodController {

    private final PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public List<PeriodResponseDto> getAll() {
        return periodService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(periodService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PeriodResponseDto> create(@Valid @RequestBody PeriodRequestDto dto) {
        return new ResponseEntity<>(periodService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodResponseDto> update(@PathVariable Long id, @Valid @RequestBody PeriodRequestDto dto) {
        return ResponseEntity.ok(periodService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        periodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
