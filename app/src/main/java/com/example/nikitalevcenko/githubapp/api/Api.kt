package com.example.nikitalevcenko.githubapp.api

import com.example.nikitalevcenko.githubapp.entity.Authorization
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

const val BASE_URL = "https://api.github.com/"

const val NOTE = "test app"

interface Api {

    @POST("/authorizationDao")
    fun login(@Header("Authorization") credentials: String,
              @Body body: AuthBodyBean = AuthBodyBean()): Single<Authorization>

    @GET("/authorizationDao")
    fun authorizations(@Header("Authorization") credentials: String): Single<List<AuthorizationBean>>

    @DELETE("/authorizationDao/{id}")
    fun removeAuthorization(@Header("Authorization") credentials: String, @Path("id") id: Long): Completable

    data class AuthorizationBean(val id: Long, val note: String)
    data class AuthBodyBean(val note: String = NOTE, val scopes: Array<String> = arrayOf("user:email"))
}