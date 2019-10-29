package com.rcorchero.footballplayers.platform.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.rcorchero.footballplayers.R
import com.rcorchero.footballplayers.platform.extensions.loadImage
import com.rcorchero.footballplayers.presentation.presenters.TeamsPresenter
import com.rcorchero.footballplayers.presentation.views.TeamCellView

class TeamsAdapter(private val presenter: TeamsPresenter) :
    RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TeamViewHolder {
        if (viewGroup is RecyclerView) {
            val view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_team, viewGroup, false)
            return TeamViewHolder(view)
        } else {
            throw RuntimeException("Not bound to RecyclerView")
        }
    }

    override fun onBindViewHolder(teamViewHolder: TeamViewHolder, position: Int) {
        presenter.configureCell(teamViewHolder, position)
    }

    override fun getItemCount(): Int = presenter.getItemsCount()

    fun refreshData() {
        notifyDataSetChanged()
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        TeamCellView, View.OnClickListener {

        private val imageView = itemView.findViewById(R.id.imageTeam) as AppCompatImageView

        init {
            itemView.setOnClickListener(this)
        }

        override fun displayImage(url: String) {
            imageView.loadImage(url = url, placeholderId = R.drawable.ic_football_club)
        }

        override fun onClick(view: View) {
            presenter.onItemClick(adapterPosition)
        }
    }
}