package com.example.SecurityExample.controllers;

import com.example.SecurityExample.domain.interfaces.StudentService;
import com.example.SecurityExample.domain.requests.AllStudent;
import com.example.SecurityExample.domain.requests.StudentRequest;
import com.example.SecurityExample.domain.responses.ErrorResponse;
import com.example.SecurityExample.domain.responses.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
@Slf4j
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<Object> userGetAllHandler() throws Exception {
        logger.info("request received to userGetHandler");
        AllStudent s;
        try {
            s = studentService.getAllStudentsID();
            return ResponseEntity.status(HttpStatus.OK).body(s);
        } catch (Exception ex) {
            ErrorResponse e = ErrorResponse.builder().msg(ex.getMessage()).code(40000).trace(UUID.randomUUID()).build();
            logger.error("error = msg:[{}] code:[{}] trace:[{}]", e.getMsg(), e.getCode(), e.getTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Object> userGetHandler(@PathVariable("studentId") final Long studentId) throws Exception {
        logger.info("request received to userGetHandler studentId[{}]", studentId);
        StudentRequest s;
        try {
            s = studentService.getStudentByID(studentId);
            return ResponseEntity.status(HttpStatus.OK).body(s);
        } catch (Exception ex) {
            ErrorResponse e = ErrorResponse.builder().msg(ex.getMessage()).code(40000).trace(UUID.randomUUID()).build();
            logger.error("error = msg:[{}] code:[{}] trace:[{}]", e.getMsg(), e.getCode(), e.getTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> userCreateHandler(@RequestBody StudentRequest request) throws Exception {
        SuccessResponse s =  studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object> userUpdateHandler(@PathVariable("studentId") final long studentId, @RequestBody StudentRequest request) throws Exception {
        request.setId(studentId);
        SuccessResponse s = studentService.updateStudent(studentId, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(s);
    }
}
