package com.example.SecurityExample.services;

import com.example.SecurityExample.domain.requests.AllStudent;
import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.ErrorResponse;
import com.example.SecurityExample.domain.responses.SuccessResponse;
import com.example.SecurityExample.domain.responses.data;
import com.example.SecurityExample.entities.StudentEntity;
import com.example.SecurityExample.domain.interfaces.StudentService;
import com.example.SecurityExample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public AllStudent getAllStudentsID() throws Exception{
        List<StudentEntity> s = studentRepository.findAll();

        ArrayList<StudentRequest> students = new ArrayList<>();
        for(StudentEntity student : s){
            students.add(StudentRequest.builder().id(student.getId()).name(student.getName()).age(student.getAge()).build());
        }
        return AllStudent.builder().data(students).build();
    }

    public StudentRequest getStudentByID(Long id) throws Exception {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isEmpty()){
            throw new Exception("user does not exist");
        }

        StudentRequest student = StudentRequest.builder().name(studentEntity.get().getName()).age(studentEntity.get().getAge()).id(studentEntity.get().getId()).build();
        return student;
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
