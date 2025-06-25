package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Department.DepartmentRequestDto;
import com.example.schoolManagementSystem.dtos.Department.DepartmentResponseDto;
import com.example.schoolManagementSystem.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@PreAuthorize("hasRole('ADMIN')")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentResponseDto> getAll() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> create(@Valid @RequestBody DepartmentRequestDto dto) {
        return new ResponseEntity<>(departmentService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> update(@PathVariable Long id,
                                                        @Valid @RequestBody DepartmentRequestDto dto) {
        return ResponseEntity.ok(departmentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
