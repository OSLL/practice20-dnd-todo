package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Backpack(
    @PrimaryKey val bid: Int,
    @ColumnInfo(name = "drawable_id") val items: List<Item>?
)