package com.rcorchero.footballplayers.data.entity

import android.content.ContentValues
import android.database.Cursor
import com.google.gson.annotations.SerializedName
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_ID_LEAGUE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_ID_SOCCER_XML
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_ID_TEAM
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_INT_FORMER_YEAR
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_INT_LOVED
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_INT_STADIUM_CAPACITY
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_ALTERNATE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_COUNTRY
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_CN
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_DE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_EN
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_ES
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_FR
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_HU
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_IL
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_IT
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_JP
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_NL
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_NO
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_PL
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_PT
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_RU
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DESCRIPTION_SE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_DIVISION
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_FACEBOOK
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_GENDER
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_INSTAGRAM
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_KEYWORDS
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_LEAGUE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_LOCKED
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_MANAGER
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_RSS
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_SPORT
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_STADIUM
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_STADIUM_DESCRIPTION
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_STADIUM_LOCATION
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_STADIUM_THUMB
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_BADGE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_BANNER
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_FANART_1
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_FANART_2
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_FANART_3
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_FANART_4
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_JERSEY
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_LOGO
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TEAM_SHORT
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_TWITTER
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_WEBSITE
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_STR_YOUTUBE

data class TeamEntity(
    @SerializedName("idLeague") val idLeague: String,
    @SerializedName("idSoccerXML") val idSoccerXML: String,
    @SerializedName("idTeam") val idTeam: String,
    @SerializedName("intFormedYear") val intFormedYear: String,
    @SerializedName("intLoved") val intLoved: String,
    @SerializedName("intStadiumCapacity") val intStadiumCapacity: String,
    @SerializedName("strAlternate") val strAlternate: String,
    @SerializedName("strCountry") val strCountry: String,
    @SerializedName("strDescriptionCN") val strDescriptionCN: String,
    @SerializedName("strDescriptionDE") val strDescriptionDE: String,
    @SerializedName("strDescriptionEN") val strDescriptionEN: String,
    @SerializedName("strDescriptionES") val strDescriptionES: String,
    @SerializedName("strDescriptionFR") val strDescriptionFR: String,
    @SerializedName("strDescriptionHU") val strDescriptionHU: String,
    @SerializedName("strDescriptionIL") val strDescriptionIL: String,
    @SerializedName("strDescriptionIT") val strDescriptionIT: String,
    @SerializedName("strDescriptionJP") val strDescriptionJP: String,
    @SerializedName("strDescriptionNL") val strDescriptionNL: String,
    @SerializedName("strDescriptionNO") val strDescriptionNO: String,
    @SerializedName("strDescriptionPL") val strDescriptionPL: String,
    @SerializedName("strDescriptionPT") val strDescriptionPT: String,
    @SerializedName("strDescriptionRU") val strDescriptionRU: String,
    @SerializedName("strDescriptionSE") val strDescriptionSE: String,
    @SerializedName("strDivision") val strDivision: String,
    @SerializedName("strFacebook") val strFacebook: String,
    @SerializedName("strGender") val strGender: String,
    @SerializedName("strInstagram") val strInstagram: String,
    @SerializedName("strKeywords") val strKeywords: String,
    @SerializedName("strLeague") val strLeague: String,
    @SerializedName("strLocked") val strLocked: String,
    @SerializedName("strManager") val strManager: String,
    @SerializedName("strRSS") val strRSS: String,
    @SerializedName("strSport") val strSport: String,
    @SerializedName("strStadium") val strStadium: String,
    @SerializedName("strStadiumDescription") val strStadiumDescription: String,
    @SerializedName("strStadiumLocation") val strStadiumLocation: String,
    @SerializedName("strStadiumThumb") val strStadiumThumb: String,
    @SerializedName("strTeam") val strTeam: String,
    @SerializedName("strTeamBadge") val strTeamBadge: String,
    @SerializedName("strTeamBanner") val strTeamBanner: String,
    @SerializedName("strTeamFanart1") val strTeamFanart1: String,
    @SerializedName("strTeamFanart2") val strTeamFanart2: String,
    @SerializedName("strTeamFanart3") val strTeamFanart3: String,
    @SerializedName("strTeamFanart4") val strTeamFanart4: String,
    @SerializedName("strTeamJersey") val strTeamJersey: String,
    @SerializedName("strTeamLogo") val strTeamLogo: String,
    @SerializedName("strTeamShort") val strTeamShort: String,
    @SerializedName("strTwitter") val strTwitter: String,
    @SerializedName("strWebsite") val strWebsite: String,
    @SerializedName("strYoutube") val strYoutube: String) {

    constructor(cursor: Cursor): this(
        cursor.getString(cursor.getColumnIndex(COLUMN_ID_LEAGUE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_ID_SOCCER_XML)),
        cursor.getString(cursor.getColumnIndex(COLUMN_ID_TEAM)),
        cursor.getString(cursor.getColumnIndex(COLUMN_INT_FORMER_YEAR)),
        cursor.getString(cursor.getColumnIndex(COLUMN_INT_LOVED)),
        cursor.getString(cursor.getColumnIndex(COLUMN_INT_STADIUM_CAPACITY)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_ALTERNATE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_COUNTRY)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_CN)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_DE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_EN)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_ES)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_FR)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_HU)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_IL)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_IT)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_JP)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_NL)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_NO)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_PL)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_PT)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_RU)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DESCRIPTION_SE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_DIVISION)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_FACEBOOK)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_GENDER)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_INSTAGRAM)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_KEYWORDS)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_LEAGUE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_LOCKED)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_MANAGER)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_RSS)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_SPORT)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_STADIUM)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_STADIUM_DESCRIPTION)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_STADIUM_LOCATION)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_STADIUM_THUMB)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_BADGE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_BANNER)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_FANART_1)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_FANART_2)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_FANART_3)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_FANART_4)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_JERSEY)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_LOGO)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TEAM_SHORT)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_TWITTER)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_WEBSITE)),
        cursor.getString(cursor.getColumnIndex(COLUMN_STR_YOUTUBE)))

    fun getContentValues(): ContentValues {
        val values = ContentValues()
        values.put(COLUMN_ID_LEAGUE, this.idLeague)
        values.put(COLUMN_ID_SOCCER_XML, this.idSoccerXML)
        values.put(COLUMN_ID_TEAM, this.idTeam)
        values.put(COLUMN_INT_FORMER_YEAR, this.intFormedYear)
        values.put(COLUMN_INT_LOVED, this.intLoved)
        values.put(COLUMN_INT_STADIUM_CAPACITY, this.intStadiumCapacity)
        values.put(COLUMN_STR_ALTERNATE, this.strAlternate)
        values.put(COLUMN_STR_COUNTRY, this.strCountry)
        values.put(COLUMN_STR_DESCRIPTION_CN, this.strDescriptionCN)
        values.put(COLUMN_STR_DESCRIPTION_DE, this.strDescriptionDE)
        values.put(COLUMN_STR_DESCRIPTION_EN, this.strDescriptionEN)
        values.put(COLUMN_STR_DESCRIPTION_ES, this.strDescriptionES)
        values.put(COLUMN_STR_DESCRIPTION_FR, this.strDescriptionFR)
        values.put(COLUMN_STR_DESCRIPTION_HU, this.strDescriptionHU)
        values.put(COLUMN_STR_DESCRIPTION_IL, this.strDescriptionIL)
        values.put(COLUMN_STR_DESCRIPTION_IT, this.strDescriptionIT)
        values.put(COLUMN_STR_DESCRIPTION_JP, this.strDescriptionJP)
        values.put(COLUMN_STR_DESCRIPTION_NL, this.strDescriptionNL)
        values.put(COLUMN_STR_DESCRIPTION_NO, this.strDescriptionNO)
        values.put(COLUMN_STR_DESCRIPTION_PL, this.strDescriptionPL)
        values.put(COLUMN_STR_DESCRIPTION_PT, this.strDescriptionPT)
        values.put(COLUMN_STR_DESCRIPTION_RU, this.strDescriptionRU)
        values.put(COLUMN_STR_DESCRIPTION_SE, this.strDescriptionSE)
        values.put(COLUMN_STR_DIVISION, this.strDivision)
        values.put(COLUMN_STR_FACEBOOK, this.strFacebook)
        values.put(COLUMN_STR_GENDER, this.strGender)
        values.put(COLUMN_STR_INSTAGRAM, this.strInstagram)
        values.put(COLUMN_STR_KEYWORDS, this.strKeywords)
        values.put(COLUMN_STR_LEAGUE, this.strLeague)
        values.put(COLUMN_STR_LOCKED, this.strLocked)
        values.put(COLUMN_STR_MANAGER, this.strManager)
        values.put(COLUMN_STR_RSS, this.strRSS)
        values.put(COLUMN_STR_SPORT, this.strSport)
        values.put(COLUMN_STR_STADIUM, this.strStadium)
        values.put(COLUMN_STR_STADIUM_DESCRIPTION, this.strStadiumDescription)
        values.put(COLUMN_STR_STADIUM_LOCATION, this.strStadiumLocation)
        values.put(COLUMN_STR_STADIUM_THUMB, this.strStadiumThumb)
        values.put(COLUMN_STR_TEAM, this.strTeam)
        values.put(COLUMN_STR_TEAM_BADGE, this.strTeamBadge)
        values.put(COLUMN_STR_TEAM_BANNER, this.strTeamBanner)
        values.put(COLUMN_STR_TEAM_FANART_1, this.strTeamFanart1)
        values.put(COLUMN_STR_TEAM_FANART_2, this.strTeamFanart2)
        values.put(COLUMN_STR_TEAM_FANART_3, this.strTeamFanart3)
        values.put(COLUMN_STR_TEAM_FANART_4, this.strTeamFanart4)
        values.put(COLUMN_STR_TEAM_JERSEY, this.strTeamJersey)
        values.put(COLUMN_STR_TEAM_LOGO, this.strTeamLogo)
        values.put(COLUMN_STR_TEAM_SHORT, this.strTeamShort)
        values.put(COLUMN_STR_TWITTER, this.strTwitter)
        values.put(COLUMN_STR_WEBSITE, this.strWebsite)
        values.put(COLUMN_STR_YOUTUBE, this.strYoutube)
        return values
    }
}