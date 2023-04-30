package com.sinut.server.students.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sinut.server.students.model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {

}
