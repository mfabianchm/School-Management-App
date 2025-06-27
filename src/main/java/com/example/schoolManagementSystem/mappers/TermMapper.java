package com.example.schoolManagementSystem.mappers;

import com.example.schoolManagementSystem.dtos.Term.TermRequestDto;
import com.example.schoolManagementSystem.dtos.Term.TermResponseDto;
import com.example.schoolManagementSystem.entities.SchoolYear;
import com.example.schoolManagementSystem.entities.Term;

public class TermMapper {
    public static Term toEntity(TermRequestDto dto, SchoolYear schoolYear) {
        Term term = new Term();
        term.setSchoolYear(schoolYear);
        term.setTermNumber(dto.getTermNumber());
        term.setStartDate(dto.getStartDate());
        term.setEndDate(dto.getEndDate());
        return term;
    }

    public static void updateEntity(Term term, TermRequestDto dto, SchoolYear schoolYear) {
        term.setSchoolYear(schoolYear);
        term.setTermNumber(dto.getTermNumber());
        term.setStartDate(dto.getStartDate());
        term.setEndDate(dto.getEndDate());
    }

    public static TermResponseDto toDto(Term term) {
        return new TermResponseDto(
                term.getId(),
                term.getTermNumber(),
                term.getStartDate(),
                term.getEndDate(),
                term.getSchoolYear().getId()
        );
    }
}
