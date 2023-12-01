package com.kotlinDemoApi.studentService

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given

import org.assertj.core.api.BDDAssertions.then


@DataJpaTest
class StudentRepositoryTest @Autowired constructor(
    val studentRepository: StudentRepository
) {

    @Test
    fun `test Student by Name & returns student details` () {

        //given
        val studentName = Student(null,"Mark")
        var savedStudent: Student = studentRepository.save(studentName)

        //when
        var student : Student = studentRepository.findByName("Mark")

        //then
        then(student.id).isNotNull()
        then(student.name).isEqualTo(savedStudent.name)

    }
}