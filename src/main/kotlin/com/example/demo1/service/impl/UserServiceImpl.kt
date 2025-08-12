package com.example.demo1.service.impl

import com.example.demo1.dto.CreateUserDto
import com.example.demo1.entity.User
import com.example.demo1.repository.UserRepository
import com.example.demo1.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findById(id: Long): User? = userRepository.findById(id).orElse(null)

    override fun createUser(dto: CreateUserDto): User {
        val user = User(name = dto.name, email = dto.email)
        return userRepository.save(user)
    }
}