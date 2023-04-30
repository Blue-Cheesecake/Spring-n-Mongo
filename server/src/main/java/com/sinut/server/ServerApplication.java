package com.sinut.server;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sinut.server.students.model.Address;
import com.sinut.server.students.model.Gender;
import com.sinut.server.students.model.Student;
import com.sinut.server.students.repo.StudentRepo;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepo studentRepo) {
		return args -> {

			// studentRepo.deleteAll();

			Student student1 = Student
					.builder()
					.firstname("Jame")
					.lastname("Arm")
					.email("Jamearm@hotmail.com")
					.gender(Gender.FEMALE)
					.address(
							Address
									.builder()
									.country("England")
									.city("London")
									.postcode("NE9")
									.build())
					.favouriteSubjects(List.of("Software Engineering", "Multimedia", "Computer Organization"))
					.totalSpentInBooks(BigDecimal.TEN)
					.created(LocalDateTime.now())
					.build();

			Student student2 = Student
					.builder()
					.firstname("Neo")
					.lastname("Stonk")
					.email("neostonk@hotmail.com")
					.gender(Gender.MALE)
					.address(
							Address
									.builder()
									.country("Thailand")
									.city("Bankgkok")
									.postcode("72990")
									.build())
					.favouriteSubjects(List.of("Accounting", "Marketing"))
					.totalSpentInBooks(BigDecimal.TEN)
					.created(LocalDateTime.now())
					.build();

			studentRepo.insert(student1);
			studentRepo.insert(student2);
		};
	}
}
