package com.makentoshe.androidgithubcitemplate

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.*
import com.makentoshe.androidgithubcgameplate.GameDao

@Database(entities = arrayOf(Game::class), version = 1, exportSchema = false)
@TypeConverters(ListItemConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "game_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
