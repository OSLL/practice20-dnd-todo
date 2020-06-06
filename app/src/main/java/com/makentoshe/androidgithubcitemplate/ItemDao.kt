package com.makentoshe.androidgithubcitemplate

import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM item WHERE iid IN (:itemIds)")
    fun loadAllByIds(itemIds: IntArray): List<Item>

    @Query("SELECT * FROM item WHERE equiped LIKE :eq")
    fun findEquiped(eq: Boolean): Item

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: Item)

    @Delete
    fun delete(item: Item)
}