package com.tochukwu.futofood.data.remote.dto

import com.tochukwu.futofood.domain.model.Fruit

data class FruitDtoItem(
    val family: String,
    val genus: String,
    val id: Int,
    val name: String,
    val nutritions: Nutritions,
    val order: String
){
    fun toFruit(): Fruit {
        return Fruit(
            family = family,
            genus = genus,
            id = id,
            name = name,
            nutritions = nutritions.toNutri(),
            order = order
        )
    }
}



