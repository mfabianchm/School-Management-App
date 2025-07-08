package com.example.schoolManagementSystem.dtos.SchoolClass;

import java.time.LocalTime;

public class SchoolClassResponseDto {

    private Long id;
    private String name;
    private Long subjectId;
    private Long teacherId;
    private Long termId;
    private LocalTime startPeriod;
    private LocalTime endPeriod;
    private Long classroomId;

    public SchoolClassResponseDto(Long id, String name, Long subjectId, Long teacherId, Long termId, LocalTime startPeriod, LocalTime endPeriod, Long classroomId) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.termId = termId;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.classroomId = classroomId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalTime getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalTime startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalTime getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalTime endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }
}
