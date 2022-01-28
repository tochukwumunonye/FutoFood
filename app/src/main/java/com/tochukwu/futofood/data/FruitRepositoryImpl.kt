package com.tochukwu.futofood.data

import com.tochukwu.futofood.data.remote.FoodService
import com.tochukwu.futofood.domain.MainRepository
import com.tochukwu.futofood.domain.model.Fruit
import com.tochukwu.futofood.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class FruitRepositoryImpl @Inject constructor(
    private val api : FoodService
) : MainRepository{

    override fun getFruits(): Flow<Resource<List<Fruit>>> = flow  {

        try{
            val result = api.getAllFruits()

            if(result.isSuccessful){
                val newResponse = result.body()?.map { it.toFruit() }
                emit(Resource.success(newResponse))
            }
        }catch(e: HttpException){
            emit(Resource.error("Couldnt't reach server", null))
        }
    }
}




