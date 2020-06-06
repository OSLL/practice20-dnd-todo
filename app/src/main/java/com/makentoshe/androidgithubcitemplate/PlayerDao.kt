package com.makentoshe.androidgithubcitemplate

import androidx.room.*

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player")
    fun getAll(): List<Player>

    @Query("SELECT * FROM player WHERE pid IN (:playerIds)")
    fun loadAllByIds(playerIds: IntArray): List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg players: Player)

    @Delete
    fun delete(player: Player)
}