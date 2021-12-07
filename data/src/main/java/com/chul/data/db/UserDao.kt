package com.chul.data.db

import androidx.room.*
import com.chul.data.model.local.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>
}