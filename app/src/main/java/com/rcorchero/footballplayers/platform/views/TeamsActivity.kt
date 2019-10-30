package com.rcorchero.footballplayers.platform.views

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.rcorchero.footballplayers.R
import com.rcorchero.footballplayers.presentation.presenters.TeamsPresenter
import com.rcorchero.footballplayers.presentation.views.TeamsView
import com.rcorchero.footballplayers.utils.League
import kotlinx.android.synthetic.main.activity_teams.*
import kotlinx.android.synthetic.main.view_leagues_selector.*
import javax.inject.Inject

class TeamsActivity : BaseActivity(), TeamsView {

    private var showLeagues = false

    @Inject
    lateinit var presenter: TeamsPresenter
    private lateinit var adapter: TeamsAdapter

    override fun getActivityLayout(): Int = R.layout.activity_teams

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        initUI()
        setListeners()

        presenter.attachView(this)
    }

    private fun initUI() {
        setUpListView()
    }

    private fun setUpListView() {
        adapter = TeamsAdapter(presenter)
        recyclerTeams.layoutManager = GridLayoutManager(this, 2)
        recyclerTeams.adapter = adapter
    }

    override fun refreshList() {
        adapter.refreshData()
    }

    private fun setListeners() {
        buttonShowLeagues.setOnClickListener {
            changeLeaguesContainerStatus(show = !showLeagues)
        }

        chipBundesliga.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_bundesliga)
            presenter.refreshTeamList(league = League.BUNDESLIGA)
        }

        chipLaLiga.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_laliga)
            presenter.refreshTeamList(league = League.LA_LIGA)
        }

        chipLigaNos.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_liganos)
            presenter.refreshTeamList(league = League.LIGA_NOS)
        }

        chipLigue1.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_ligue1)
            presenter.refreshTeamList(league = League.LIGUE_1)
        }

        chipPremierLeague.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_premierleague)
            presenter.refreshTeamList(league = League.PREMIER_LEAGUE)
        }

        chipSerieA.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_seriea)
            presenter.refreshTeamList(league = League.SERIE_A)
        }

        /*recyclerTeams.setOnClickListener {
            changeLeaguesContainerStatus(show = false)
        }*/
    }

    private fun changeLeagueSelectedImage(imageId: Int) {
        imageLeagueSelected.setImageResource(imageId)

        changeLeaguesContainerStatus(show = !showLeagues)
    }

    private fun changeLeaguesContainerStatus(show: Boolean) {
        showLeagues = show

        leaguesContainer.visibility =
            if (showLeagues) {
                View.VISIBLE
            } else {
                View.GONE
            }

        buttonShowLeagues.setImageResource(
            if (showLeagues) {
                R.drawable.ic_up_arrow
            } else {
                R.drawable.ic_down_arrow
            }
        )
    }
}