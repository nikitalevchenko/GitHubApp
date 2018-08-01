package com.example.nikitalevcenko.githubapp.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.nikitalevcenko.githubapp.entity.Authorization
import io.reactivex.Flowable

@Dao
interface AuthorizationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(authorization: Authorization)

    @Query("select * from Authorization")
    fun authorizations(): Flowable<List<Authorization>>
}