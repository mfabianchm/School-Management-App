package com.example.schoolManagementSystem.dtos.SchoolClass;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SchoolClassRequestDto {

    @NotBlank
    private String name;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long termId;

    @NotNull
    private Long periodId;

    @NotNull
    private Long classroomId;

    public SchoolClassRequestDto() {
    }

    public SchoolClassRequestDto(String name, Long subjectId, Long teacherId, Long termId, Long periodId, Long classroomId) {
        this.name = name;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.termId = termId;
        this.periodId = periodId;
        this.classroomId = classroomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }


    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
