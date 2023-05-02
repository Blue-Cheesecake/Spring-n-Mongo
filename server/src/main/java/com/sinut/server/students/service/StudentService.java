package com.sinut.server.students.service;

import com.sinut.server.students.model.Student;
import com.sinut.server.students.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudent(String email) {
        return studentRepo.findStudentByEmail(email);
    }

}