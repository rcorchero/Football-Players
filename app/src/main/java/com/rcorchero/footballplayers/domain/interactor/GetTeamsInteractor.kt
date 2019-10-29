package com.rcorchero.footballplayers.domain.interactor

import com.rcorchero.footballplayers.domain.interactor.common.Interactor
import com.rcorchero.footballplayers.domain.model.Team
import com.rcorchero.footballplayers.domain.repository.TeamsRepository
import com.rcorchero.footballplayers.utils.League
import javax.inject.Inject

class GetTeamsInteractor<T>
@Inject constructor(private val repository: TeamsRepository) : Interactor<T>() {

    private var onlyOnline: Boolean = false
    private lateinit var league: League

    override suspend fun execution(): List<Team> = repository.getTeams(onlyOnline, league)

    fun setParams(onlyOnline: Boolean, league: League) {
        this.onlyOnline = onlyOnline
        this.league = league
    }
}