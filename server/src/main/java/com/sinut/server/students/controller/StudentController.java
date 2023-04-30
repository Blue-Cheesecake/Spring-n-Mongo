package com.sinut.server.students.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinut.server.students.model.Student;
import com.sinut.server.students.repo.StudentRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepo studentRepo;

    @CrossOrigin
    @GetMapping("/get/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok().body(studentRepo.findAll());
    }

    @CrossOrigin
    @GetMapping("/get/{email}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable(name = "email") String email) {
        return ResponseEntity.ok().body(studentRepo.findStudentByEmail(email));
    }
}
