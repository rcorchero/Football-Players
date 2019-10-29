package com.rcorchero.footballplayers.data.source.remote

import com.rcorchero.footballplayers.data.entity.TeamEntity
import com.rcorchero.footballplayers.utils.League

interface RemoteDataSource {

    @Throws(Exception::class)
    fun getTeamsInLeague(league: League): List<TeamEntity>
}