package com.example.anime_list.network

import com.example.anime_list.model.SeasonNowResponse
import com.example.anime_list.model.SeasonUpcomingResponse
import com.example.anime_list.model.TopAnimeResponse
import retrofit2.Response
import retrofit2.http.GET



interface JikanApiService {
    @GET("seasons/now")
    suspend fun getThisSeason(): Response<SeasonNowResponse>

    //next season

    @GET(value = "seasons/upcoming")
    suspend fun getNextSeason(): Response<SeasonUpcomingResponse>


    @GET(value = "top/anime")
    suspend fun getTrending(): Response<TopAnimeResponse>

    //top anime

    //all anime

    //
}