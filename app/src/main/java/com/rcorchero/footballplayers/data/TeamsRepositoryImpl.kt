package com.rcorchero.footballplayers.data

import com.rcorchero.footballplayers.data.entity.TeamEntity
import com.rcorchero.footballplayers.data.mapper.toDomain
import com.rcorchero.footballplayers.data.source.local.LocalDataSource
import com.rcorchero.footballplayers.data.source.remote.RemoteDataSource
import com.rcorchero.footballplayers.domain.model.Team
import com.rcorchero.footballplayers.domain.repository.TeamsRepository
import com.rcorchero.footballplayers.utils.League

class TeamsRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource): TeamsRepository {

    override fun getTeams(onlyOnline: Boolean, league: League): List<Team> {
        var teamsList: List<TeamEntity>

        if (onlyOnline) {
            teamsList = remoteDataSource.getTeamsInLeague(league = league)
            saveData(teamsList)
        } else {
            teamsList = localDataSource.getTeams()
            if (teamsList.isEmpty()) {
                teamsList = remoteDataSource.getTeamsInLeague(league = league)
                saveData(teamsList)
            }
        }
        return teamsList.toDomain()
    }

    private fun saveData(teamsList: List<TeamEntity>) {
        localDataSource.deleteAllTeams()
        localDataSource.saveTeams(teamsList)
    }

    override fun getTeam(teamId: String): Team =
        localDataSource.getTeam(teamId)!!.toDomain()
}