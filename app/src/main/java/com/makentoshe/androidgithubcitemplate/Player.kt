package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey val pid: Int,
    @ColumnInfo(name = "health") var hp: Int?,
    @ColumnInfo(name = "mana") var mana: Int?,
    @ColumnInfo(name = "experience") var exp: Int?,
    @ColumnInfo(name = "max_health") var maxHp: Int?,
    @ColumnInfo(name = "max_mana") var maxMana: Int?,
    @ColumnInfo(name = "max_experience") var maxExp: Int?,
    //@ColumnInfo(name = "backpack") val backpack: Backpack?,
    @Embedded
    var backpack: Backpack?,
    @Embedded
    var equipedItems: List<Item>?
    //@ColumnInfo(name = "equiped_items") val equipedItems: List<Item>
    )