package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey(autoGenerate = true) var iid: Int = 0,
    @ColumnInfo(name = "drawable_id") var drawableId: Int = 0,
    @ColumnInfo(name = "type_of_item") var typeOfItem: String = "",
    @ColumnInfo(name = "extend_hp") var extendHp: Int = 0,
    @ColumnInfo(name = "equiped") var equiped: Boolean = false
)