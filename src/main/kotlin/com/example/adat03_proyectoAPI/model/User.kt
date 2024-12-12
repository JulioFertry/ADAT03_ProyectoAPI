package com.example.adat03_proyectoAPI.model

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, length = 25, nullable = false)
    var username: String? = null,

    @Column(unique = true, length = 50, nullable = false)
    var email: String? = null,

    @Column(unique = false, length = 50, nullable = false)
    var password: String? = null,

    @ManyToMany(mappedBy = "users")
    var fridge: MutableList<Ingredient>? = mutableListOf()

)