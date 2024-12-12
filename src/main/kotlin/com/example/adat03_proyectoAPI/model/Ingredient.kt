package com.example.adat03_proyectoAPI.model

import jakarta.persistence.*


@Entity
@Table(name = "ingredients")
data class Ingredient(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 30, nullable = false)
    val name: String? = null,

    @ManyToMany
    @JoinTable(
        name = "ingredient_user",
        joinColumns = [JoinColumn(name = "ingredient_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var users: MutableList<User>? = mutableListOf(),

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "ingredient_recipe",
        joinColumns = [JoinColumn(name = "ingredient_id")],
        inverseJoinColumns = [JoinColumn(name = "recipe_id")]
    )
    var recipes: MutableList<Recipe>? = mutableListOf()

)