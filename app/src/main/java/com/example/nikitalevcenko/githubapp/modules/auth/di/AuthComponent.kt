package com.example.nikitalevcenko.githubapp.modules.auth.di

import com.example.nikitalevcenko.githubapp.modules.auth.presentation.AuthPresenter
import dagger.Subcomponent

@Subcomponent(modules = [(AuthModule::class)])
interface AuthComponent {
    fun inject(authPresenter: AuthPresenter)
}