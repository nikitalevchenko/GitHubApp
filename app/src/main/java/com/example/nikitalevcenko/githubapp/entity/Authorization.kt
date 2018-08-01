package com.example.nikitalevcenko.githubapp.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Authorization(

        @PrimaryKey()
        @SerializedName("authorizationId")
        val id: Long,

        val token: String
)