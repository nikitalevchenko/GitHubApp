package com.example.nikitalevcenko.githubapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.nikitalevcenko.githubapp.entity.Authorization

@Database(
        entities = [(Authorization::class)],
        version = 1,
        exportSchema = false
)
abstract class DB : RoomDatabase() {
    abstract val authorizationDao: AuthorizationDao
}