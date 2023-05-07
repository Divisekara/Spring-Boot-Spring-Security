package com.example.SecurityExample.services;

import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.SuccessResponse;
import com.example.SecurityExample.domain.responses.data;
import com.example.SecurityExample.entities.StudentEntity;
import com.example.SecurityExample.domain.interfaces.StudentService;
import com.example.SecurityExample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity getStudentByID(Long id){
        return studentRepository.getReferenceById(id);
    }

    public SuccessResponse createStudent(StudentRequest student){
        StudentEntity s = StudentEntity.builder().name(student.getName()).age(student.getAge()).build();
        return SuccessResponse.builder().data(data.builder().id(studentRepository.save(s).getId()).build()).build();
    }

    public SuccessResponse updateStudent(Long id, StudentRequest student){
        StudentEntity s = StudentEntity.builder().name(student.getName()).age(student.getAge()).id(student.getId()).build();
        return SuccessResponse.builder().data(data.builder().id(studentRepository.save(s).getId()).build()).build();
    }

}
