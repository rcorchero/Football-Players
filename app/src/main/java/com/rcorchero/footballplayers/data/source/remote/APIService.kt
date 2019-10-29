package com.rcorchero.footballplayers.data.source.remote

import com.rcorchero.footballplayers.data.entity.TeamEntityList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("lookup_all_teams.php")
    fun getTeamsInLeague(@Query("id") id: String): Call<TeamEntityList>
}