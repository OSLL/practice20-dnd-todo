package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "health") val hp: Int?,
    @ColumnInfo(name = "mana") val mana: Int?,
    @ColumnInfo(name = "experience") val exp: Int?,
    @ColumnInfo(name = "max_health") val maxHp: Int?,
    @ColumnInfo(name = "max_mana") val maxMana: Int?,
    @ColumnInfo(name = "max_experience") val maxExp: Int?,
    @ColumnInfo(name = "backpack") val backpack: Backpack?,
    @ColumnInfo(name = "equiped_items") val equipedItems: List<Item>
    )