package com.example.amigospring.student

import com.example.amigospring.student.data.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping( "api/v1/students")
class StudentController @Autowired constructor(val studentService: StudentService) {

    @GetMapping("/all")
    fun students() = studentService.students()

    @PostMapping("add_student")
    fun registerNewStudent(@RequestBody student: Student) : String {
        return studentService.addNewStudent(student)
    }

    @DeleteMapping(path = ["{studentId}"])
    fun deleteStudent(@PathVariable("studentId") id : Long) : String {
        return studentService.deleteStudent(id)
    }

    @PutMapping(path = ["{studentId}"])
    fun updateStudent(
        @PathVariable("studentId") id : Long,
        @RequestParam(required = false) email : String?,
        @RequestParam(required = false) name : String?) : String {
        return studentService.updateStudent(id, name, email)
    }

}