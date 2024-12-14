package com.example.adat03_proyectoAPI.service

import com.example.adat03_proyectoAPI.model.UserModel
import com.example.adat03_proyectoAPI.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService


class UserService: UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository


    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userRepository
            .findByUsername(username!!)
            .orElseThrow()


        return User.builder()
            .username(user.username)
            .password(user.password)
            .roles(user.roles)
            .build( )
    }

}