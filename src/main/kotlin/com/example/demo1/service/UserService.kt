package com.example.demo1.service

import com.example.demo1.dto.CreateUserDto
import com.example.demo1.entity.User

interface UserService {
    fun findById(id: Long): User?
    fun createUser(dto: CreateUserDto): User
}