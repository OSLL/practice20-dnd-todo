package com.makentoshe.androidgithubcgameplate

import androidx.room.*
import com.makentoshe.androidgithubcitemplate.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM game")
    fun getAll(): List<Game>

    @Query("SELECT * FROM game WHERE gid IN (:gameIds)")
    fun loadAllByIds(gameIds: IntArray): List<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg games: Game)

    @Delete
    fun delete(game: Game)
}