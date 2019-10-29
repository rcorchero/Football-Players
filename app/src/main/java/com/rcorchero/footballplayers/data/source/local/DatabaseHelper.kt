package com.rcorchero.footballplayers.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Database Info
private const val DATABASE_NAME = "footballPlayersDB"
private const val DATABASE_VERSION = 1

// Table Name
private const val TABLE_TEAMS = "teams"

// Teams Table KEYs
private const val KEY_ID_LEAGUE = "idLeague"
private const val KEY_ID_SOCCER_XML = "idSoccerXML"
private const val KEY_ID_TEAM = "idTeam"
private const val KEY_INT_FORMER_YEAR = "intFormedYear"
private const val KEY_INT_LOVED = "intLoved"
private const val KEY_INT_STADIUM_CAPACITY = "intStadiumCapacity"
private const val KEY_STR_ALTERNATE = "strAlternate"
private const val KEY_STR_COUNTRY = "strCountry"
private const val KEY_STR_DESCRIPTION_CN = "strDescriptionCN"
private const val KEY_STR_DESCRIPTION_DE = "strDescriptionDE"
private const val KEY_STR_DESCRIPTION_EN = "strDescriptionEN"
private const val KEY_STR_DESCRIPTION_ES = "strDescriptionES"
private const val KEY_STR_DESCRIPTION_FR = "strDescriptionFR"
private const val KEY_STR_DESCRIPTION_HU = "strDescriptionHU"
private const val KEY_STR_DESCRIPTION_IL = "strDescriptionIL"
private const val KEY_STR_DESCRIPTION_IT = "strDescriptionIT"
private const val KEY_STR_DESCRIPTION_JP = "strDescriptionJP"
private const val KEY_STR_DESCRIPTION_NL = "strDescriptionNL"
private const val KEY_STR_DESCRIPTION_NO = "strDescriptionNO"
private const val KEY_STR_DESCRIPTION_PL = "strDescriptionPL"
private const val KEY_STR_DESCRIPTION_PT = "strDescriptionPT"
private const val KEY_STR_DESCRIPTION_RU = "strDescriptionRU"
private const val KEY_STR_DESCRIPTION_SE = "strDescriptionSE"
private const val KEY_STR_DIVISION = "strDivision"
private const val KEY_STR_FACEBOOK = "strFacebook"
private const val KEY_STR_GENDER = "strGender"
private const val KEY_STR_INSTAGRAM = "strInstagram"
private const val KEY_STR_KEYWORDS = "strKeywords"
private const val KEY_STR_LEAGUE = "strLeague"
private const val KEY_STR_LOCKED = "strLocked"
private const val KEY_STR_MANAGER = "strManager"
private const val KEY_STR_RSS = "strRSS"
private const val KEY_STR_SPORT = "strSport"
private const val KEY_STR_STADIUM = "strStadium"
private const val KEY_STR_STADIUM_DESCRIPTION = "strStadiumDescription"
private const val KEY_STR_STADIUM_LOCATION = "strStadiumLocation"
private const val KEY_STR_STADIUM_THUMB = "strStadiumThumb"
private const val KEY_STR_TEAM = "strTeam"
private const val KEY_STR_TEAM_BADGE = "strTeamBadge"
private const val KEY_STR_TEAM_BANNER = "strTeamBanner"
private const val KEY_STR_TEAM_FANART_1 = "strTeamFanart1"
private const val KEY_STR_TEAM_FANART_2 = "strTeamFanart2"
private const val KEY_STR_TEAM_FANART_3 = "strTeamFanart3"
private const val KEY_STR_TEAM_FANART_4 = "strTeamFanart4"
private const val KEY_STR_TEAM_JERSEY = "strTeamJersey"
private const val KEY_STR_TEAM_LOGO = "strTeamLogo"
private const val KEY_STR_TEAM_SHORT = "strTeamShort"
private const val KEY_STR_TWITTER = "strTwitter"
private const val KEY_STR_WEBSITE = "strWebsite"
private const val KEY_STR_YOUTUBE = "strYoutube"

class DatabaseHelper(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Called when the database is created for the FIRST time.
    override fun onCreate(db: SQLiteDatabase) {
        val queryCreateTable = "CREATE TABLE " + TABLE_TEAMS +
                "(" +
                KEY_ID_TEAM + " TEXT PRIMARY KEY," +
                KEY_ID_LEAGUE + " TEXT," +
                KEY_ID_SOCCER_XML + " TEXT," +
                KEY_INT_FORMER_YEAR + " TEXT," +
                KEY_INT_LOVED + " TEXT," +
                KEY_INT_STADIUM_CAPACITY + " TEXT," +
                KEY_STR_ALTERNATE + " TEXT," +
                KEY_STR_COUNTRY + " TEXT," +
                KEY_STR_DESCRIPTION_CN + " TEXT," +
                KEY_STR_DESCRIPTION_DE + " TEXT," +
                KEY_STR_DESCRIPTION_EN + " TEXT," +
                KEY_STR_DESCRIPTION_ES + " TEXT," +
                KEY_STR_DESCRIPTION_FR + " TEXT," +
                KEY_STR_DESCRIPTION_HU + " TEXT," +
                KEY_STR_DESCRIPTION_IL + " TEXT," +
                KEY_STR_DESCRIPTION_IT + " TEXT," +
                KEY_STR_DESCRIPTION_JP + " TEXT," +
                KEY_STR_DESCRIPTION_NL + " TEXT," +
                KEY_STR_DESCRIPTION_NO + " TEXT," +
                KEY_STR_DESCRIPTION_PL + " TEXT," +
                KEY_STR_DESCRIPTION_PT + " TEXT," +
                KEY_STR_DESCRIPTION_RU + " TEXT," +
                KEY_STR_DESCRIPTION_SE + " TEXT," +
                KEY_STR_DIVISION + " TEXT," +
                KEY_STR_FACEBOOK + " TEXT," +
                KEY_STR_GENDER + " TEXT," +
                KEY_STR_INSTAGRAM + " TEXT," +
                KEY_STR_KEYWORDS + " TEXT," +
                KEY_STR_LEAGUE + " TEXT," +
                KEY_STR_LOCKED + " TEXT," +
                KEY_STR_MANAGER + " TEXT," +
                KEY_STR_RSS + " TEXT," +
                KEY_STR_SPORT + " TEXT," +
                KEY_STR_STADIUM + " TEXT," +
                KEY_STR_STADIUM_DESCRIPTION + " TEXT," +
                KEY_STR_STADIUM_LOCATION + " TEXT," +
                KEY_STR_STADIUM_THUMB + " TEXT," +
                KEY_STR_TEAM + " TEXT," +
                KEY_STR_TEAM_BADGE + " TEXT," +
                KEY_STR_TEAM_BANNER + " TEXT," +
                KEY_STR_TEAM_FANART_1 + " TEXT," +
                KEY_STR_TEAM_FANART_2 + " TEXT," +
                KEY_STR_TEAM_FANART_3 + " TEXT," +
                KEY_STR_TEAM_FANART_4 + " TEXT," +
                KEY_STR_TEAM_JERSEY + " TEXT," +
                KEY_STR_TEAM_LOGO + " TEXT," +
                KEY_STR_TEAM_SHORT + " TEXT," +
                KEY_STR_TWITTER + " TEXT," +
                KEY_STR_WEBSITE + " TEXT," +
                KEY_STR_YOUTUBE + " TEXT" +
                ")"

        db.execSQL(queryCreateTable)
    }

    // Called when the database needs to be upgraded.
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Simplest implementation is to drop all old tables and recreate them
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_TEAMS")
            onCreate(db)
        }
    }
}