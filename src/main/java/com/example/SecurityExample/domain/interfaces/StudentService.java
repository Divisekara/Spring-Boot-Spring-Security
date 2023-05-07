package com.example.SecurityExample.domain.interfaces;

import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.SuccessResponse;
import com.example.SecurityExample.entities.StudentEntity;

public interface StudentService {
    StudentEntity getStudentByID(Long id);
    SuccessResponse createStudent(StudentRequest student);
    SuccessResponse updateStudent(Long StudentId, StudentRequest student);
}
