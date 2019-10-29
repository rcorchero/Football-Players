package com.rcorchero.footballplayers.data.source.local

import android.database.sqlite.SQLiteOpenHelper
import com.rcorchero.footballplayers.data.entity.TeamEntity
import com.rcorchero.footballplayers.data.source.local.TeamContract.COLUMN_ID_TEAM
import com.rcorchero.footballplayers.data.source.local.TeamContract.TABLE_NAME

class LocalDataSourceImpl(
    private val sqLiteOpenHelper: SQLiteOpenHelper): LocalDataSource {

    override fun getTeams(): List<TeamEntity> {
        val db = sqLiteOpenHelper.readableDatabase
        val sql = "SELECT * FROM $TABLE_NAME"
        val teamEntityList = ArrayList<TeamEntity>()

        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            do {
                teamEntityList.add(TeamEntity(cursor))
            } while (cursor.moveToNext())
        }

        if (!cursor.isClosed) {
            cursor.close()
        }

        return teamEntityList
    }

    override fun getTeam(teamId: String): TeamEntity? {
        val db = sqLiteOpenHelper.readableDatabase
        val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID_TEAM = \"$teamId\""
        var teamEntity: TeamEntity? = null

        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            teamEntity = TeamEntity(cursor)
        }

        if (!cursor.isClosed) {
            cursor.close()
        }

        return teamEntity
    }

    override fun saveTeams(teamsList: List<TeamEntity>) {
        val db = sqLiteOpenHelper.writableDatabase

        db.beginTransaction()
        for (teamEntity in teamsList) {
            db.insert(TABLE_NAME, null, teamEntity.getContentValues())
        }
        db.setTransactionSuccessful()
        db.endTransaction()
    }

    override fun deleteAllTeams() {
        val db = sqLiteOpenHelper.writableDatabase
        db.delete(TABLE_NAME, null, null)
    }
}