package com.tochukwu.futofood.data.remote.dto

import com.tochukwu.futofood.domain.model.Nutri

data class Nutritions(
    val calories: Double,
    val carbohydrates: Double,
    val fat: Double,
    val protein: Double,
    val sugar: Double
){
    fun toNutri(): Nutri{
        return Nutri(
            calories = calories,
            carbohydrates = carbohydrates,
            fat = fat,
            protein = protein,
            sugar = sugar
        )
    }
}

