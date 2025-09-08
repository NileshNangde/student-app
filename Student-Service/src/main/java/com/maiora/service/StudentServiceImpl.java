package com.maiora.service;

import com.maiora.constant.AppConstant;
import com.maiora.dto.StudentDto;
import com.maiora.entity.Student;
import com.maiora.exception.ResourceNotFoundException;
import com.maiora.mapper.Mapper;
import com.maiora.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
 
	@Autowired
    private StudentRepository studentRepository;
	

    @Override
    public StudentDto createStudent(StudentDto dto) {
        
        Student student =  Mapper.mapToEntity(dto);
        return Mapper.mapToDto(studentRepository.save(student));
    }

    @Override
    public StudentDto getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstant.STUDENT_NOT_FOUND + id));
        return Mapper.mapToDto(student);
    }

    @Override
    public List<StudentDto> getStudentsBetween18And25() {
        List<Student> students = studentRepository.findByAgeBetween(18, 25);
        return students.stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateAge(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(AppConstant.STUDENT_NOT_FOUND + id));

        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(student.getDobYear(), student.getDobMonth(), student.getDobDay());
        int age = today.getYear() - dob.getYear();
        if (today.getDayOfYear() < dob.getDayOfYear()) {
            age--;
        }

        student.setAge(age);
        return Mapper.mapToDto(studentRepository.save(student));
    }
}
