package com.example.adat03_proyectoAPI.model

import jakarta.persistence.*


@Entity
@Table(name = "recipes")
data class Recipe(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, length = 50, nullable = false)
    var name: String? = null,

    @Column(length = 1000, nullable = true)
    var description: String? = null,

    @ManyToMany(mappedBy = "recipes")
    var ingredients: MutableList<Ingredient>? = mutableListOf()

)