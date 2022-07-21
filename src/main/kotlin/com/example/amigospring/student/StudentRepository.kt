package com.example.amigospring.student

import com.example.amigospring.student.data.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : JpaRepository<Student, Long> {

    fun findStudentByEmail(email : String) : Student?

}