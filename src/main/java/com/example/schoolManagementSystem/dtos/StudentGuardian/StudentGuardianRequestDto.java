package com.example.schoolManagementSystem.dtos.StudentGuardian;

public class StudentGuardianRequestDto {
    private Long studentId;
    private Long guardianId;
    private Long guardianTypeId;

    public StudentGuardianRequestDto() {}

    public StudentGuardianRequestDto(Long studentId, Long guardianId, Long guardianTypeId) {
        this.studentId = studentId;
        this.guardianId = guardianId;
        this.guardianTypeId = guardianTypeId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Long guardianId) {
        this.guardianId = guardianId;
    }

    public Long getGuardianTypeId() {
        return guardianTypeId;
    }

    public void setGuardianTypeId(Long guardianTypeId) {
        this.guardianTypeId = guardianTypeId;
    }


}
