package com.example.demo1.dto

import com.example.demo1.entity.User

data class UserDto(val id: Long, val name: String, val email: String) {
    companion object {
        fun fromEntity(user: User): UserDto =
            UserDto(id = user.id, name = user.name, email = user.email)
    }
}
