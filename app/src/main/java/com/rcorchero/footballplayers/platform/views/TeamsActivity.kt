package com.rcorchero.footballplayers.platform.views

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.rcorchero.footballplayers.R
import com.rcorchero.footballplayers.presentation.views.TeamsView
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
        setUpRefreshView()
    }

    private fun setUpListView() {
        adapter = TeamsAdapter(presenter)
        recyclerTeams.layoutManager = GridLayoutManager(this, 2)
        recyclerTeams.adapter = adapter
    }

    private fun setUpRefreshView() {
        refreshLayout.setOnRefreshListener { presenter.refresh() }
    }

    override fun refreshList() {
        adapter.refreshData()
    }

    override fun cancelRefreshDialog() {
        refreshLayout.isRefreshing = false
    }

    private fun setListeners() {
        buttonShowLeagues.setOnClickListener {
            changeLeaguesContainerStatus(show = !showLeagues)
        }

        chipBundesliga.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_bundesliga)
        }

        chipLaLiga.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_laliga)
        }

        chipLigaNos.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_liganos)
        }

        chipLigue1.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_ligue1)
        }

        chipPremierLeague.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_premierleague)
        }

        chipSerieA.setOnClickListener {
            changeLeagueSelectedImage(imageId = R.drawable.ic_league_seriea)
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