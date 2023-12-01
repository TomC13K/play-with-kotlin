package com.kotlinDemoApi.studentService

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class StudentRepositoryTest @Autowired constructor(
    val studentRepository: StudentRepository
) {

    @Test
    fun `test Student by Name & returns student details` () {

        //given
        val student = Student(null,"Mark")
        var savedStudent: Student = studentRepository.save(student)

        //when

        //then

    }
}