package com.example.nikitalevcenko.githubapp.modules.auth.view

import android.support.annotation.StringRes
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.nikitalevcenko.githubapp.base.ui.ErrorView

@StateStrategyType(SingleStateStrategy::class)
interface AuthView : MvpView, ErrorView {
    fun setLoginError(@StringRes errorRes: Int?)
    fun setPasswordError(@StringRes errorRes: Int?)
    fun setLogin(login: String)
    fun setPassword(password: String)
    fun setLoaderVisibility(visible: Boolean)
    fun navigateToMainScreen()
}