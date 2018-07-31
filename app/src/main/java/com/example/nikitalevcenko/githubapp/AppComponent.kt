package com.example.nikitalevcenko.githubapp

import com.example.nikitalevcenko.githubapp.modules.auth.di.AuthComponent
import com.example.nikitalevcenko.githubapp.modules.auth.di.AuthModule
import com.example.nikitalevcenko.githubapp.modules.main.di.MainComponent
import com.example.nikitalevcenko.githubapp.modules.main.di.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(app: App)

    // Subcomponents
    fun plus(module: AuthModule): AuthComponent

    fun plus(module: MainModule): MainComponent
}