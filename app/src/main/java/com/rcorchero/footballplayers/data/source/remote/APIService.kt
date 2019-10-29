package com.rcorchero.footballplayers.data.source.remote

import com.rcorchero.footballplayers.data.entity.TeamEntityList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    companion object {
        const val ID_BUNDESLIGA = "4331"
        const val ID_LA_LIGA = "4335"
        const val ID_LIGA_NOS = "4344"
        const val ID_LIGUE_1 = "4334"
        const val ID_PREMIER_LEAGUE = "4328"
        const val ID_SERIE_A = "4332"
    }

    @GET("lookup_all_teams.php")
    fun getTeamsInLeague(@Query("id") id: String): Call<TeamEntityList>
}