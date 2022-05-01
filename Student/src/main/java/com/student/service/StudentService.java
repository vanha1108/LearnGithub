package com.student.service;

import com.student.dto.StudentDTO;
import com.student.entity.Student;
import javassist.NotFoundException;

public interface StudentService {

    Student createStudent(StudentDTO studentDTO);

    Student updateStudent(Long id, StudentDTO studentDTO) throws NotFoundException;

    Student getById(Long id) throws NotFoundException;
}
