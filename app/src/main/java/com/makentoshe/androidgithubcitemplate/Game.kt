package com.makentoshe.androidgithubcitemplate

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true) val gid: Int = 0,
    //@ColumnInfo(name = "player") val player: Player
    @Embedded
    public var player: Player = Player()
)