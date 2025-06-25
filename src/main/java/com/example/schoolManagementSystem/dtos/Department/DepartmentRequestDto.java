package com.example.schoolManagementSystem.dtos.Department;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDto {
    @NotBlank
    private String departmentName;


    public DepartmentRequestDto() {
    }

    public DepartmentRequestDto(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NotBlank String departmentName) {
        this.departmentName = departmentName;
    }
}
