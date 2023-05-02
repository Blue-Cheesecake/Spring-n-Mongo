package com.sinut.server.students.service;

import com.sinut.server.exception.AlreadyExistsException;
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

    public void addStudent(Student student) throws AlreadyExistsException {
        Optional<Student> studentResult = getStudent(student.getEmail());
        if (studentResult.isPresent()) {
            throw new AlreadyExistsException("The student email: " + student.getEmail() + " already exist");
        }
        studentRepo.save(student);
    }

    public void clear() {
        studentRepo.deleteAll();
    }

}
