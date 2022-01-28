package com.tochukwu.futofood.di

import com.tochukwu.futofood.data.FruitRepositoryImpl
import com.tochukwu.futofood.data.remote.FoodService
import com.tochukwu.futofood.data.remote.FoodService.Companion.BASE_URL
import com.tochukwu.futofood.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Singleton
    @Provides
    fun providesConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providesOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        return okHttpClient.build()
    }


    @Singleton
    @Provides
    fun providesRetrofit(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)

        return retrofit.build()
    }



    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }

    @Singleton
    @Provides
    fun provideFruitRepository(api: FoodService) = FruitRepositoryImpl(
        api = api
    ) as MainRepository

}



/**

@Module
@InstallIn(SingletonComponent::class)

object AppModule {


    @Singleton
    @Provides
    fun provideDisneyDatabase(app : Application) :DisneyDatabase{
        return Room.databaseBuilder(app, DisneyDatabase::class.java, DISNEY_DATABASE_NAME).allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideCharacterRepository(
        dao: DisneyDao,
        api: ApiService,
        map: PosterEntityMapper
    ) = MainRepositoryImpl(
        dao = dao,
        api = api,
        map = map
    ) as MainRepository

}  **/