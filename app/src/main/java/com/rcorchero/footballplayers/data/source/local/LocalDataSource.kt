package com.rcorchero.footballplayers.data.source.local

import com.rcorchero.footballplayers.data.entity.TeamEntity

interface LocalDataSource {

    fun getTeams(): List<TeamEntity>

    fun getTeam(teamId: String): TeamEntity?

    fun saveTeams(teamsList: List<TeamEntity>)

    fun deleteAllTeams()
}