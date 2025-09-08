package com.maiora.mapper;

import org.modelmapper.ModelMapper;

import com.maiora.dto.StudentDto;
import com.maiora.entity.Student;

public class Mapper {

	private static final ModelMapper mapper = new ModelMapper();
	
	public static StudentDto mapToDto(Student entity) {
		return mapper.map(entity, StudentDto.class);
	}
	
	public static Student mapToEntity(StudentDto dto ) {
		return mapper.map(dto, Student.class);
	}
	
}
