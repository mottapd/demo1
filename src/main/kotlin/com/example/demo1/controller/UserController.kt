package com.example.demo1.controller

import com.example.demo1.dto.CreateUserDto
import com.example.demo1.dto.UserDto
import com.example.demo1.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDto> =
        userService.findById(id)
            ?.let { ResponseEntity.ok(UserDto.fromEntity(it)) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createUser(@RequestBody dto: CreateUserDto): ResponseEntity<UserDto> {
        val created = userService.createUser(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDto.fromEntity(created))
    }
}