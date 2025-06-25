package com.example.schoolManagementSystem.dtos.SchoolSubject;

public class SchoolSubjectResponseDto {
    private Long id;
    private String subjectName;
    private Long departmentId;
    private String departmentName;

    public SchoolSubjectResponseDto() {
    }

    public SchoolSubjectResponseDto(Long id, String subjectName, Long departmentId, String departmentName) {
        this.id = id;
        this.subjectName = subjectName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Long getId() { return id; }
    public String getSubjectName() { return subjectName; }
    public Long getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
}
