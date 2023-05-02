package com.sinut.server.students.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;

    public static Student fromRequest(StudentRequest request) {
        return Student
                .builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .gender(request.getGender())
                .address(request.getAddress())
                .favouriteSubjects(request.getFavouriteSubjects())
                .totalSpentInBooks(BigDecimal.valueOf(request.getTotalSpentInBooks()))
                .created(LocalDateTime.now())
                .build();
    }
}
