package com.makentoshe.androidgithubcitemplate

import androidx.room.*

// TODO: 6/5/2020 write backpackDao add insert that add item to backpack

@Dao
interface BackpackDao {
    @Query("SELECT * FROM backpack")
    fun getAll(): List<Backpack>

    @Query("SELECT * FROM backpack WHERE bid = :id")
    fun loadByIds(id: Int): Backpack

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: Item)

    @Delete
    fun delete(backpack: Backpack)
}