package com.example.nikitalevcenko.githubapp.modules.auth.interactor

import io.reactivex.Completable

interface AuthInteractor {
    fun login(login: String, password: String): Completable
}