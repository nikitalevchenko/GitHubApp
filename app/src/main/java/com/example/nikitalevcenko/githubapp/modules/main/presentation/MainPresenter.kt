package com.example.nikitalevcenko.githubapp.modules.main.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.nikitalevcenko.githubapp.App
import com.example.nikitalevcenko.githubapp.modules.main.di.MainModule
import com.example.nikitalevcenko.githubapp.modules.main.interactor.MainInteractor
import com.example.nikitalevcenko.githubapp.modules.main.view.MainView
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var interactor: MainInteractor

    init {
        App.component.plus(MainModule()).inject(this)

        if (!interactor.isAuthorized) {
            viewState.navigateToAuth()
        }
    }

    fun onSettingsClick() {
        viewState.navigateToSettings()
    }
}