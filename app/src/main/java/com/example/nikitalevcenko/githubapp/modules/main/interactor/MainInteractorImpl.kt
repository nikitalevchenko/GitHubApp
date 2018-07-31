package com.example.nikitalevcenko.githubapp.modules.main.interactor

import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepo

class MainInteractorImpl(private val authRepo: AuthRepo) : MainInteractor {
    override val isAuthorized: Boolean
        get() = authRepo.isAuthorized
}