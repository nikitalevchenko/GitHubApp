package com.example.nikitalevcenko.githubapp.api

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

const val BASE_URL = "https://api.github.com/"

const val NOTE = "test app"

interface Api {

    @POST("/authorizations")
    fun login(@Header("Authorization") credentials: String,
              @Body body: AuthBody = AuthBody()): Single<LoginResult>

    @GET("/authorizations")
    fun authorizations(@Header("Authorization") credentials: String): Single<List<Authorization>>

    @DELETE("/authorizations/{id}")
    fun removeAuthorization(@Header("Authorization") credentials: String, @Path("id") id: Long): Completable

    data class LoginResult(val authorizationId: Long, val token: String)
    data class Authorization(val id: Long, val note: String)
    data class AuthBody(val note: String = NOTE, val scopes: Array<String> = arrayOf("user:email"))
}