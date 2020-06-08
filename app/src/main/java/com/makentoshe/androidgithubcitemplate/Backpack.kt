package com.makentoshe.androidgithubcitemplate

import androidx.room.*

@Entity
data class Backpack(
    @PrimaryKey(autoGenerate = true) val bid: Int = 0,
    @TypeConverters(ListItemConverter::class)
    var items: List<Item> = emptyList()
    //@ColumnInfo(name = "list_of_items") val items: List<Item>?
)