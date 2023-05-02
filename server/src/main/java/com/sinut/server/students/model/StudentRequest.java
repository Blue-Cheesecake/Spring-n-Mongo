package com.sinut.server.students.model;

import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private String firstname;
    private String lastname;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private int totalSpentInBooks;
}
