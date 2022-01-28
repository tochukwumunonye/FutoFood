package com.tochukwu.futofood.domain.model

data class Fruit(
    val family: String,
    val genus: String,
    val id: Int,
    val name: String,
    val nutritions: Nutri,
    val order: String
) {
}
