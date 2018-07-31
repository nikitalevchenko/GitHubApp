package com.example.nikitalevcenko.githubapp.repo.auth

import io.reactivex.Completable

interface AuthRepo {
    fun login(login: String, password: String): Completable
}