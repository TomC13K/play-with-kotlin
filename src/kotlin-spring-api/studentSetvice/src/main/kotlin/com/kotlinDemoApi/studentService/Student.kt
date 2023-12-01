package com.kotlinDemoApi.studentService

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Student(
    @Id @GeneratedValue var id: Long? = null,
    val name: String?)