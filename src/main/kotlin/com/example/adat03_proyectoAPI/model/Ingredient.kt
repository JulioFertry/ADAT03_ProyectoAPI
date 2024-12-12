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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "ingredient_recipe",
        joinColumns = [JoinColumn(name = "ingredient_id")],
        inverseJoinColumns = [JoinColumn(name = "recipe_id")]
    )
    var recipes: MutableList<Recipe>? = mutableListOf()

)