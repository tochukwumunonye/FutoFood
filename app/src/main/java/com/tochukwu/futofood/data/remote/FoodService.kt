package com.tochukwu.futofood.data.remote

import com.tochukwu.futofood.data.remote.dto.FruitDtoItem
import retrofit2.Response
import retrofit2.http.GET

interface FoodService {


    @GET("fruit/all")
    suspend fun  getAllFruits() : Response<List<FruitDtoItem>>

    companion object {
        const val BASE_URL = "https://fruityvice.com/api/"
    }
}


/**

//suspend fun fetchDisneyPosterList(): Response<PosterDto>




https://www.fruityvice.com/api/fruit/all   **/