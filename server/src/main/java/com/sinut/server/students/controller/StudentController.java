package com.sinut.server.students.controller;

import com.sinut.server.students.model.Student;
import com.sinut.server.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @CrossOrigin
    @GetMapping("/get/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @CrossOrigin
    @GetMapping("/get/{email}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable(name = "email") String email) {
        return ResponseEntity.ok(studentService.getStudent(email));
    }
}
