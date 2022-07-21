package com.example.amigospring.student.data

import java.time.LocalDate
import java.time.Period
import javax.persistence.*

@Entity
@Table
data class Student(

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val id : Long = 0L,
    var name : String,
    val dob : LocalDate,
    var email : String,

    ) {

    val age
        get() = Period.between(dob, LocalDate.now()).years

}
