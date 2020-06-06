package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey val gid: Int,
    //@ColumnInfo(name = "player") val player: Player
    @Embedded
    var player: Player
)