package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Backpack(
    @PrimaryKey val bid: Int,
    @Embedded
    var items: List<Item>?
    //@ColumnInfo(name = "drawable_id") val items: List<Item>?
)