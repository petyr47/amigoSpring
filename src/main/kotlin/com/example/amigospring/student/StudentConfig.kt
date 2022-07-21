package com.example.amigospring.student

import com.example.amigospring.student.data.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class StudentConfig {

    @Bean
    fun commandLineRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner { args ->
            repository.saveAll(
            listOf(
                Student(
                    name = "Aneke",
                    dob = LocalDate.of(1996, 7, 1),
                    email = "peter@aneke.com",
                ),
                Student(
                    name = "Peter",
                    dob = LocalDate.of(1999, 7, 1),
                    email = "aneke@peter.com",
                )
            ))
        }
    }

}