package com.example.anime_list.data

import com.example.anime_list.model.SeasonNowResponse
import com.example.anime_list.model.SeasonUpcomingResponse
import com.example.anime_list.model.TopAnimeResponse
import com.example.anime_list.network.JikanApiService
import retrofit2.Response

interface JikanRepository{
    suspend fun getThisSeaon() : Response<SeasonNowResponse>

    suspend fun getNextSeason() : Response<SeasonUpcomingResponse>

    suspend fun getTrending() : Response<TopAnimeResponse>
}


class NetworkJikanRepository(
    private val jikanApiService: JikanApiService
) : JikanRepository{
    override suspend fun getThisSeaon(): Response<SeasonNowResponse>  = jikanApiService.getThisSeason()

    override suspend fun getTrending(): Response<TopAnimeResponse>  = jikanApiService.getTrending()

    override suspend fun getNextSeason(): Response<SeasonUpcomingResponse> = jikanApiService.getNextSeason()
}