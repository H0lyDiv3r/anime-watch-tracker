package com.example.anime_list.network

import com.example.anime_list.model.SeasonNowResponse
import com.example.anime_list.model.SeasonUpcomingResponse
import retrofit2.Response
import retrofit2.http.GET



interface JikanApiService {
    @GET("seasons/now")
    suspend fun getThisSeason(): Response<SeasonNowResponse>

    //next season

    @GET(value = "seasons/upcoming")
    suspend fun getNextSeason(): Response<SeasonUpcomingResponse>


    suspend fun getTrending(): Response<SeasonNowResponse>

    //top anime

    //all anime

    //
}