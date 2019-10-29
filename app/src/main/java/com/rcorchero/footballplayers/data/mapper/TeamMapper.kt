package com.rcorchero.footballplayers.data.mapper

import com.rcorchero.footballplayers.data.entity.TeamEntity
import com.rcorchero.footballplayers.domain.model.Team

fun List<TeamEntity>.toDomain(): List<Team> =
    this.map { it.toDomain() }

fun TeamEntity.toDomain(): Team =
    Team(
        id = idTeam,
        name = strTeam,
        altName = strAlternate,
        shortName = strTeamShort,

        formedYear = intFormedYear,
        country = strCountry,

        descriptionEN = strDescriptionEN,
        descriptionES = strDescriptionES,

        manager = strManager,

        stadium = Team.Stadium(
            name = strStadium,
            description = strStadiumDescription,
            capacity = intStadiumCapacity,
            location = strStadiumLocation,
            thumb = strStadiumThumb
        ),
        socialNetworks = Team.SocialNetworks(
            facebook = strFacebook,
            instagram = strInstagram,
            twitter = strTwitter,
            website = strWebsite,
            youtube = strYoutube
        ),
        images = Team.Images(
            badge = strTeamBadge,
            banner = strTeamBanner,
            fanarts = arrayListOf(strTeamFanart1, strTeamFanart2, strTeamFanart3, strTeamFanart4),
            jersey = strTeamJersey,
            logo = strTeamLogo
        )
    )