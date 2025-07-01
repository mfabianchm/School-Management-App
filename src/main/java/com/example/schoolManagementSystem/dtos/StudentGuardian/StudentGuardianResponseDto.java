package com.example.schoolManagementSystem.dtos.StudentGuardian;

public class StudentGuardianResponseDto {

    private Long id;
    private Long studentId;
    private Long guardianId;
    private String guardianType;

    public StudentGuardianResponseDto(Long id, Long studentId, Long guardianId, String guardianType) {
        this.id = id;
        this.studentId = studentId;
        this.guardianId = guardianId;
        this.guardianType = guardianType;
    }

    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public Long getGuardianId() { return guardianId; }
    public String getGuardianType() { return guardianType; }
}
