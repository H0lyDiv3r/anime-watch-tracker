package com.example.anime_list.data

import com.example.anime_list.model.SeasonNowResponse
import com.example.anime_list.network.JikanApiService
import retrofit2.Response

interface JikanRepository{
    suspend fun getThisSeaon() : Response<SeasonNowResponse>
}


class NetworkJikanRepository(
    private val jikanApiService: JikanApiService
) : JikanRepository{
    override suspend fun getThisSeaon(): Response<SeasonNowResponse>  = jikanApiService.getThisSeason()
}