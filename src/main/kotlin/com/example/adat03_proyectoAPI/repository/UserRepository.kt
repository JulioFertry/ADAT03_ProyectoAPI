package com.example.adat03_proyectoAPI.repository

import com.example.adat03_proyectoAPI.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional


@Repository
interface UserRepository: JpaRepository<UserModel, Long> {

    // Implementar una derived query para obtener a un usuario por su nombre
    fun findByUsername(username: String): Optional<UserModel>

}