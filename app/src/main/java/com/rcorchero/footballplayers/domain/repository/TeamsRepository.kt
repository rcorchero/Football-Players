package com.rcorchero.footballplayers.domain.repository

import com.rcorchero.footballplayers.domain.model.Team
import com.rcorchero.footballplayers.utils.League

interface TeamsRepository {

    @Throws(Exception::class)
    fun getTeams(onlyOnline: Boolean, league: League): List<Team>

    fun getTeam(teamId: String): Team
}