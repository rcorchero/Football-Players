package com.rcorchero.footballplayers.data.source.remote

import com.rcorchero.footballplayers.data.entity.TeamEntity
import com.rcorchero.footballplayers.data.entity.TeamEntityList
import com.rcorchero.footballplayers.utils.League

class RemoteDataSourceImpl(apiService: APIService) : Repository(apiService), RemoteDataSource {

    @Throws(Exception::class)
    override fun getTeamsInLeague(league: League): List<TeamEntity> {
        val executeCall = executeCall(apiService.getTeamsInLeague(id = league.id))
        val response = executeCall.body() as TeamEntityList
        return response.teams
    }
}