package com.student.service.impl;

import com.student.dto.StudentDTO;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setBod(studentDTO.getBod());
        student.setGender(studentDTO.getGender());
        return studentRepository.save(student);
    }

    @Override
    public Student getById(final Long id) throws NotFoundException {
//        Optional<Student> studentOpt = studentRepository.findById(id);
//        if (!studentOpt.isPresent()) {
//            throw new NotFoundException("Student not exist");
//        }
//        return studentOpt.get();
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student not exist"));
    }

    @Override
    public Student updateStudent(final Long id, final StudentDTO studentDTO) throws NotFoundException {
        Student student = this.getById(id);
        if (!StringUtils.isBlank(studentDTO.getFirstName())) {
            student.setFirstName(studentDTO.getFirstName());
        }
        if (!StringUtils.isBlank(studentDTO.getLastName())) {
            student.setLastName(studentDTO.getLastName());
        }
        if (studentDTO.getBod() != null) {
            student.setBod(studentDTO.getBod());
        }
        if (student.getGender() != null) {
            student.setGender(studentDTO.getGender());
        }
        return studentRepository.save(student);
    }
}
