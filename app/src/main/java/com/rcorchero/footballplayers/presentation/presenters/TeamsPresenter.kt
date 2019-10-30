package com.rcorchero.footballplayers.presentation.presenters

import com.rcorchero.footballplayers.domain.interactor.GetTeamsInteractor
import com.rcorchero.footballplayers.domain.model.Team
import com.rcorchero.footballplayers.presentation.views.TeamCellView
import com.rcorchero.footballplayers.presentation.views.TeamsView
import com.rcorchero.footballplayers.utils.League
import javax.inject.Inject

class TeamsPresenter
@Inject constructor(private val getTeamsInteractor: GetTeamsInteractor<List<Team>>): BasePresenter<TeamsView>() {

    private var teamsList = emptyList<Team>()

    override fun onViewAttached() {
        view.showLoading()

        getTeamsInteractor.setParams(true, league = League.LA_LIGA)
        execute(getTeamsInteractor, this::onSuccess, this::onError)
    }

    override fun onViewDetached() {
        cancel()
    }

    private fun cancel() {
        getTeamsInteractor.cancel()
        view.hideLoading()
    }

    fun refreshTeamList(league: League) {
        view.showLoading()

        getTeamsInteractor.setParams(false, league = league)
        execute(getTeamsInteractor, this::onSuccess, this::onError)
    }

    private fun onSuccess(teams: List<Team>) {
        view.hideLoading()

        saveTeams(teams)

        view.refreshList()
    }

    private fun onError() {
        view.hideLoading()

        view.showDefaultError()
    }

    fun getItemsCount(): Int =
        if(teamsListIsEmpty())
            0
        else
            teamsList.size

    fun configureCell(teamCellView: TeamCellView, position: Int) {
        val team = getTeam(position)
        teamCellView.displayImage(url = team.images.badge)
        teamCellView.displayTeamName(name = team.name)
    }

    private fun saveTeams(teamsList: List<Team>) {
        this.teamsList = teamsList
    }

    private fun getTeam(position: Int): Team = teamsList[position]

    private fun teamsListIsEmpty(): Boolean = teamsList.isEmpty()
}