package com.example.nikitalevcenko.githubapp.modules.auth.di

import android.support.annotation.NonNull
import com.example.nikitalevcenko.githubapp.modules.auth.interactor.AuthInteractor
import com.example.nikitalevcenko.githubapp.modules.auth.interactor.AuthInteractorImpl
import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepo
import dagger.Module
import dagger.Provides

@Module
class AuthModule {

    @Provides
    @NonNull
    fun interactor(authRepo: AuthRepo): AuthInteractor = AuthInteractorImpl(authRepo)
}