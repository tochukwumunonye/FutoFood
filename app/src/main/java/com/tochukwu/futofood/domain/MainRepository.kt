package com.tochukwu.futofood.domain


import com.tochukwu.futofood.domain.model.Fruit
import com.tochukwu.futofood.util.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getFruits() : Flow<Resource<List<Fruit>>>
}

/**

interface MainRepository {

fun getPoster() : Flow<Resource<List<PosterDtoItem>>>

fun getPosterById(id: Int?) : Flow<PosterDtoItem>
}
        **/