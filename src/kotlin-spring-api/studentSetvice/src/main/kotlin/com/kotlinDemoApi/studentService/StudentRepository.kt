package com.kotlinDemoApi.studentService

import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>{
    fun findByName(name: String): Student
    fun save(student: Student): Student
}