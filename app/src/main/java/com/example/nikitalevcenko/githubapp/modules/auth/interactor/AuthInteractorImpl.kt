package com.example.nikitalevcenko.githubapp.modules.auth.interactor

import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepo
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthInteractorImpl(private val authRepo: AuthRepo) : AuthInteractor {

    override fun login(login: String, password: String): Completable {
        return authRepo.login(login, password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}