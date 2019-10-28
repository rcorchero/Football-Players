package com.rcorchero.footballplayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.view_leagues_selector.*

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        buttonShowLeagues.setOnClickListener {
            leaguesContainer.visibility = View.VISIBLE
        }
    }
}