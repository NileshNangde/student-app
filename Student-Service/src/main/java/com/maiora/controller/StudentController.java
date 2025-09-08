package com.maiora.controller;

import com.maiora.dto.StudentDto;
import com.maiora.response.AppResponse;
import com.maiora.service.StudentService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<AppResponse<StudentDto>> create(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(AppResponse.success(studentService.createStudent(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResponse<StudentDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(AppResponse.success(studentService.getStudent(id)));
    }

    @GetMapping("/between-18-25")
    public ResponseEntity<AppResponse<List<StudentDto>>> getBetween18And25() {
        return ResponseEntity.ok(AppResponse.success(studentService.getStudentsBetween18And25()));
    }

    @PutMapping("/{id}/update-age")
    public ResponseEntity<AppResponse<StudentDto>> updateAge(@PathVariable Long id) {
        return ResponseEntity.ok(AppResponse.success(studentService.updateAge(id)));
    }
}
