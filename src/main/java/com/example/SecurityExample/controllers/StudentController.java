package com.example.SecurityExample.controllers;

import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.SuccessResponse;
import com.example.SecurityExample.domain.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}")
    public Object userGetHandler(@PathVariable("studentId") final Long studentId) throws Exception{
        return studentService.getStudentByID(studentId);
    }

    @PostMapping
    public SuccessResponse userCreateHandler(@RequestBody StudentRequest request) throws Exception{
        return studentService.createStudent(request);
    }

    @PutMapping("/{studentId}")
    public SuccessResponse userUpdateHandler(@PathVariable("studentId") final long studentId, @RequestBody StudentRequest request) throws Exception{
        request.setId(studentId);
        return studentService.updateStudent(studentId, request);
    }
}
