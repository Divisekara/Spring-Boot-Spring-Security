package com.example.SecurityExample.domain.interfaces;

import com.example.SecurityExample.domain.requests.AllStudent;
import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.SuccessResponse;

public interface StudentService {
    AllStudent getAllStudentsID() throws Exception;

    StudentRequest getStudentByID(Long id) throws Exception;

    SuccessResponse createStudent(StudentRequest student);

    SuccessResponse updateStudent(Long StudentId, StudentRequest student);
}
