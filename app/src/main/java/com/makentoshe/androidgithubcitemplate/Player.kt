package com.makentoshe.androidgithubcitemplate

import androidx.room.*

@Entity
data class Player(
    @PrimaryKey(autoGenerate = true) val pid: Int = 0,
    @ColumnInfo(name = "health") var hp: Int? = 100,
    @ColumnInfo(name = "mana") var mana: Int? = 100,
    @ColumnInfo(name = "experience") var exp: Int? = 0,
    @ColumnInfo(name = "max_health") var maxHp: Int? = 100,
    @ColumnInfo(name = "max_mana") var maxMana: Int? = 100,
    @ColumnInfo(name = "max_experience") var maxExp: Int? = 999999999,
    @ColumnInfo(name = "armor") var armor: Int? = 0,
    @ColumnInfo(name = "attack") var attack: Int? = 5,
    //@ColumnInfo(name = "backpack") val backpack: Backpack?,
    @Embedded
    var backpack: Backpack? = Backpack(),
    @TypeConverters(ListItemConverter::class)
    var equipedItems: List<Item> = emptyList()
    //@ColumnInfo(name = "equiped_items") val equipedItems: List<Item>
    )