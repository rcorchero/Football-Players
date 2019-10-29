package com.rcorchero.footballplayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_teams.*
import kotlinx.android.synthetic.main.view_leagues_selector.*

class TeamsActivity : AppCompatActivity() {

    private var showLeagues = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        setListeners()
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

        recyclerTeams.setOnClickListener {
            changeLeaguesContainerStatus(show = false)
        }
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