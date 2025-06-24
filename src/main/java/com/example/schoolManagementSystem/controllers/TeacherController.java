package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Teachers.TeacherRequestDto;
import com.example.schoolManagementSystem.dtos.Teachers.TeacherResponseDto;
import com.example.schoolManagementSystem.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TeacherResponseDto> createTeacher(@RequestBody @Valid TeacherRequestDto dto) {
        TeacherResponseDto createdTeacher = teacherService.createTeacher(dto);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<TeacherResponseDto> getAllTeachers() {
        return teacherService.getAllTeachers();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TeacherResponseDto> getTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponseDto> updateTeacher(@PathVariable Long id,
                                                            @RequestBody @Valid TeacherRequestDto dto,
                                                            Authentication auth) {
        if (isTeacher(auth) && !teacherService.isOwner(id, auth.getName())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(teacherService.updateTeacher(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    // Utility method to check if user is TEACHER
    private boolean isTeacher(Authentication auth) {
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_TEACHER"));
    }
}
