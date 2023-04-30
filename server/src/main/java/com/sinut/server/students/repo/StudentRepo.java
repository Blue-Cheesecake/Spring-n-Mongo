package com.sinut.server.students.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sinut.server.students.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
}
