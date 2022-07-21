package com.example.amigospring.student

import com.example.amigospring.student.data.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class StudentService @Autowired constructor(val repository : StudentRepository) {

    fun students() = repository.findAll()


    fun addNewStudent(student: Student) : String {
        val findByEmail = repository.findStudentByEmail(student.email)
        if (findByEmail != null){
           throw IllegalStateException("Email already exists!")
        }
        repository.save(student)
        return "Student ${student.name} Saved Successfully"
    }

    fun deleteStudent(id: Long): String {
        val findById = repository.findById(id)
        if (findById.isEmpty){
            return "Student does not exist!"
        }
        repository.deleteById(id)
        return "Student Deleted Successfully!"
    }

    @Transactional
    fun updateStudent(id: Long, name: String?, email: String?): String {
        val studentWithId = repository.findById(id).orElseThrow {
            IllegalStateException("Student with id $id does not exist!")
        }
        if (!name.isNullOrBlank() && studentWithId.name != name){
            studentWithId.name = name
        }
        if (!email.isNullOrBlank() && studentWithId.email != email){
            val studentByEmail = repository.findStudentByEmail(email)
            if (studentByEmail != null){
               throw IllegalStateException("Student with email $email already exists!")
            }
            studentWithId.email = email
        }
        return "Updated Successfully!"
    }

}