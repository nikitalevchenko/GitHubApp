package com.example.nikitalevcenko.githubapp.modules.main.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainView : MvpView {
    fun navigateToAuth()
    fun popBack()
    fun navigateToSettings()
    fun exitApp()
}