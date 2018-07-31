package com.example.nikitalevcenko.githubapp.modules.main.di

import android.support.annotation.NonNull
import com.example.nikitalevcenko.githubapp.modules.main.interactor.MainInteractor
import com.example.nikitalevcenko.githubapp.modules.main.interactor.MainInteractorImpl
import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepo
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    @NonNull
    fun interactor(authRepo: AuthRepo): MainInteractor = MainInteractorImpl(authRepo)
}