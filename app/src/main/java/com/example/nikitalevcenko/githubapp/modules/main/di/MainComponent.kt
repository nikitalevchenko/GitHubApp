package com.example.nikitalevcenko.githubapp.modules.main.di

import com.example.nikitalevcenko.githubapp.modules.main.presentation.MainPresenter
import dagger.Subcomponent

@Subcomponent(modules = [(MainModule::class)])
interface MainComponent {
    fun inject(mainPresenter: MainPresenter)
}