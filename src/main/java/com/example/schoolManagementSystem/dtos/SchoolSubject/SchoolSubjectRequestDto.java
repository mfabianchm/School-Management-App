package com.example.schoolManagementSystem.dtos.SchoolSubject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SchoolSubjectRequestDto {
    @NotBlank
    private String subjectName;

    @NotNull
    private Long departmentId;

    public SchoolSubjectRequestDto() {
    }

    public SchoolSubjectRequestDto(String subjectName, Long departmentId) {
        this.subjectName = subjectName;
        this.departmentId = departmentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
