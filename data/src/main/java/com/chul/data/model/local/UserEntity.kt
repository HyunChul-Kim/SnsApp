package com.chul.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chul.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val userId: Int
)

fun UserEntity.toDomain() = User("", "", userId)