package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey val iid: Int,
    @ColumnInfo(name = "drawable_id") val drawableId: Int?,
    @ColumnInfo(name = "type_of_item") val typeOfItem: String?,
    @ColumnInfo(name = "extend_hp") val extendHp: Int?,
    @ColumnInfo(name = "equiped") val equiped: Boolean
)