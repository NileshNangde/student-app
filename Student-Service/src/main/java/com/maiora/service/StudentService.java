package com.maiora.service;

import com.maiora.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto dto);
    StudentDto getStudent(Long id);
    List<StudentDto> getStudentsBetween18And25();
    StudentDto updateAge(Long id);
}
