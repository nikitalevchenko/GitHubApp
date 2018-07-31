package com.example.nikitalevcenko.githubapp.modules.main.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.nikitalevcenko.githubapp.App
import com.example.nikitalevcenko.githubapp.R
import com.example.nikitalevcenko.githubapp.modules.main.di.MainModule
import com.example.nikitalevcenko.githubapp.modules.main.interactor.MainInteractor
import com.example.nikitalevcenko.githubapp.modules.main.view.MainView
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private var currentItemId = R.id.navigation_report

    @Inject
    lateinit var interactor: MainInteractor

    init {
        App.component.plus(MainModule()).inject(this)

        if (!interactor.isAuthorized) {
            viewState.navigateToAuth()
        }
    }

    fun onOnNavigationItemSelected(itemId: Int) {
        if (itemId == currentItemId) return

        when (itemId) {
            R.id.navigation_report -> {
                viewState.popBack()
            }
            R.id.navigation_settings -> {
                viewState.navigateToSettings()
            }
        }

        currentItemId = itemId
    }

    fun onBackPressed() {
        if (currentItemId == R.id.navigation_report) {
            viewState.exitApp()
        } else {
            viewState.popBack()
            currentItemId = R.id.navigation_report
        }
    }
}