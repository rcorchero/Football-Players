package com.rcorchero.footballplayers.presentation.presenters

import com.rcorchero.footballplayers.domain.interactor.GetTeamsInteractor
import com.rcorchero.footballplayers.domain.model.Team
import com.rcorchero.footballplayers.presentation.views.TeamCellView
import com.rcorchero.footballplayers.presentation.views.TeamsView
import com.rcorchero.footballplayers.utils.League
import javax.inject.Inject

class TeamsPresenter
@Inject constructor(private val getTeamsInteractor: GetTeamsInteractor<List<Team>>): BasePresenter<TeamsView>() {

    var teamsList = emptyList<Team>()

    private var selectedAvengerName: String = ""

    override fun onViewAttached() {
        view.showLoading()

        getTeamsInteractor.setParams(false)
        execute(getTeamsInteractor, this::onSuccess, this::onError)
    }

    override fun onViewDetached() {
        cancel()
    }

    fun cancel() {
        getTeamsInteractor.cancel()
        view.hideLoading()
    }

    fun refresh() {
        getTeamsInteractor.setParams(true, league = League.LA_LIGA)
        execute(getTeamsInteractor, this::onSuccess, this::onError)
    }

    private fun onSuccess(teams: List<Team>) {
        view.hideLoading()

        saveTeams(teams)
        view.let {
            it.cancelRefreshDialog()
            it.refreshList()
        }
    }

    private fun onError() {
        view.let {
            it.cancelRefreshDialog()
            it.showDefaultError()
        }
    }

    fun getItemsCount(): Int =
        if(teamsListIsEmpty())
            0
        else
            teamsList.size

    fun configureCell(teamCellView: TeamCellView, position: Int) {
        val team = getTeam(position)
        teamCellView.displayImage(team.images.logo)
    }

    private fun saveTeams(teamsList: List<Team>) {
        this.teamsList = teamsList
    }

    private fun getTeam(position: Int): Team = teamsList[position]

    private fun teamsListIsEmpty(): Boolean = teamsList.isEmpty()
}