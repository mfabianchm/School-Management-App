package com.example.schoolManagementSystem.services;

import com.example.schoolManagementSystem.dtos.SchoolClass.SchoolClassRequestDto;
import com.example.schoolManagementSystem.dtos.SchoolClass.SchoolClassResponseDto;
import com.example.schoolManagementSystem.entities.*;
import com.example.schoolManagementSystem.exceptions.ResourceNotFoundException;
import com.example.schoolManagementSystem.mappers.SchoolClassMapper;
import com.example.schoolManagementSystem.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SchoolClassService {

    private static final Logger log = LoggerFactory.getLogger(SchoolClassService.class);

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolSubjectRepository schoolSubjectRepository;
    private final TeacherRepository teacherRepository;
    private final TermRepository termRepository;
    private final PeriodRepository periodRepository;
    private final ClassroomRepository classroomRepository;

    SchoolClassService(
            SchoolClassRepository schoolClassRepository,
            SchoolSubjectRepository schoolSubjectRepository,
            TeacherRepository teacherRepository,
            TermRepository termRepository,
            PeriodRepository periodRepository,
            ClassroomRepository classroomRepository
    ) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolSubjectRepository = schoolSubjectRepository;
        this.teacherRepository = teacherRepository;
        this.termRepository = termRepository;
        this.periodRepository = periodRepository;
        this.classroomRepository = classroomRepository;
    }


    @Transactional
    public SchoolClassResponseDto create(SchoolClassRequestDto dto) {
        if (schoolClassRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("School Class already exists");
        }

        SchoolSubject subject = schoolSubjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("School subject not found"));

        Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        Term term = termRepository.findById(dto.getTermId())
                .orElseThrow(() -> new ResourceNotFoundException("Term not found"));

        Period period = periodRepository.findById(dto.getPeriodId())
                .orElseThrow(() -> new RuntimeException("Start period not found"));
        log.info("Fetched period: {}", period);

        Classroom classroom = classroomRepository.findById(dto.getClassroomId())
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));


        // Create and save the SchoolClass

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(dto.getName());
        schoolClass.setSubject(subject);
        schoolClass.setTeacher(teacher);
        schoolClass.setTerm(term);
        schoolClass.setPeriod(period);
        schoolClass.setClassroom(classroom);

        log.info("Saving SchoolClass with name: {}", schoolClass.getName());
        log.info("Subject: {}, Teacher: {}, Term: {}, Period: {}, Classroom: {}",
                subject.getId(), teacher.getId(), term.getId(), period.getId(), classroom.getId());

        SchoolClass saved = schoolClassRepository.save(schoolClass);

        return SchoolClassMapper.toDto(saved);
    }


    public List<SchoolClassResponseDto> getAllSchoolClasses() {
        return schoolClassRepository.findAll().stream()
                .map(SchoolClassMapper::toDto)
                .collect(Collectors.toList());
    }


    public SchoolClassResponseDto getSchoolClassById(Long id) {
        return schoolClassRepository.findById(id)
                .map(SchoolClassMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolClass not found"));
    }

    public SchoolClassResponseDto updateSchoolClass(Long id, SchoolClassRequestDto dto) {
        SchoolClass schoolClass = schoolClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolClass not found"));


        SchoolSubject subject = schoolSubjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        Term term = termRepository.findById(dto.getTermId())
                .orElseThrow(() -> new ResourceNotFoundException("Term not found"));

        Period period = periodRepository.findById(dto.getPeriodId())
                .orElseThrow(() -> new ResourceNotFoundException("Period not found"));

        Classroom classroom = classroomRepository.findById(dto.getClassroomId())
                .orElseThrow(() -> new ResourceNotFoundException("Classroom not found"));


        schoolClass.setName(dto.getName());
        schoolClass.setSubject(subject);
        schoolClass.setTeacher(teacher);
        schoolClass.setTerm(term);
        schoolClass.setPeriod(period);
        schoolClass.setClassroom(classroom);


        SchoolClass updated = schoolClassRepository.save(schoolClass);
        return SchoolClassMapper.toDto(updated);

    }

    public void delete(Long id) {
        SchoolClass schoolClass = schoolClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SchoolClass not found"));

        schoolClassRepository.delete(schoolClass);
    }
}
