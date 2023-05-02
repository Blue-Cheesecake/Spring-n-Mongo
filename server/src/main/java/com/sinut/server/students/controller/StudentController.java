package com.sinut.server.students.controller;

import com.sinut.server.exception.AlreadyExistsException;
import com.sinut.server.students.model.Student;
import com.sinut.server.students.model.StudentRequest;
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

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequest request) {
        try {
            studentService.addStudent(Student.fromRequest(request));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.ok("Some Fields are already exists");
        }
        return ResponseEntity.ok("Added");
    }

    @CrossOrigin
    @DeleteMapping("/del")
    public ResponseEntity<String> deleteAllStudent() {
        studentService.clear();
        return ResponseEntity.ok("Deleted");
    }
}
