package com.rcorchero.footballplayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        val leagueImages =
            listOf(R.drawable.ic_league_laliga, R.drawable.ic_league_premierleague,
                R.drawable.ic_league_seriea, R.drawable.ic_league_bundesliga, R.drawable.ic_league_ligue1)

        val adapter = CustomArrayAdapter(this, R.layout.item_spinner, leagueImages)
        spinnerLeagues.adapter = adapter
    }
}