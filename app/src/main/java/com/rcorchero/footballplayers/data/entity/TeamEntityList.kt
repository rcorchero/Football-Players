package com.rcorchero.footballplayers.data.entity

import com.google.gson.annotations.SerializedName

data class TeamEntityList(
    @SerializedName("teams")
    val teams: List<TeamEntity>
)