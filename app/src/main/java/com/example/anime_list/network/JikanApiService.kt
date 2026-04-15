package com.example.anime_list.network

import com.example.anime_list.model.SeasonNowResponse
import retrofit2.Response
import retrofit2.http.GET



interface JikanApiService {
    @GET("seasons/now")
    suspend fun getThisSeason(): Response<SeasonNowResponse>
}