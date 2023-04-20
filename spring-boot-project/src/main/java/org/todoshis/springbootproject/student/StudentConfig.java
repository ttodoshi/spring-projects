package org.todoshis.springbootproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student vladick = new Student("Vladick", LocalDate.of(2003, Month.DECEMBER, 1), "sashko@mail.com");
            Student jora = new Student("Jorik", LocalDate.of(2002, Month.DECEMBER, 15), "jorik@mail.com");
            studentRepository.saveAll(List.of(vladick, jora));
        };
    }
}
