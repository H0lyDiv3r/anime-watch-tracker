package com.example.anime_list.data
import com.example.anime_list.network.JikanApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
interface AppContainer {
    val jikanRepository: JikanRepository
}

class DefaultAppContainer: AppContainer {


    private val jikanBaseUrl = "https://api.jikan.moe/v4/"
    private val retrofit:Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(jikanBaseUrl)
        .build()


    private val retrofitService: JikanApiService by lazy {
        retrofit.create(JikanApiService::class.java)
    }

    /**
     * DI implementation for Mars photos repository
     */
    override val jikanRepository: JikanRepository by lazy {
        NetworkJikanRepository(retrofitService)
    }
}