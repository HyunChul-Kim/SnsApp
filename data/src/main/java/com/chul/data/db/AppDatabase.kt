package com.chul.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chul.data.model.local.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}