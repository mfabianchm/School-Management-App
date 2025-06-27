package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Term.TermRequestDto;
import com.example.schoolManagementSystem.dtos.Term.TermResponseDto;
import com.example.schoolManagementSystem.services.TermService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terms")
@PreAuthorize("hasRole('ADMIN')")
public class TermController {

    private final TermService termService;

    public TermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping
    public List<TermResponseDto> getAll() {
        return termService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TermResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(termService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TermResponseDto> create(@Valid @RequestBody TermRequestDto dto) {
        return new ResponseEntity<>(termService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TermResponseDto> update(@PathVariable Long id,
                                                  @Valid @RequestBody TermRequestDto dto) {
        return ResponseEntity.ok(termService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        termService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
