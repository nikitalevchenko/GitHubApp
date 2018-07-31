package com.example.nikitalevcenko.githubapp.modules.auth.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.nikitalevcenko.githubapp.App
import com.example.nikitalevcenko.githubapp.R
import com.example.nikitalevcenko.githubapp.modules.auth.di.AuthModule
import com.example.nikitalevcenko.githubapp.modules.auth.interactor.AuthInteractor
import com.example.nikitalevcenko.githubapp.modules.auth.view.AuthView
import io.reactivex.disposables.Disposable
import retrofit2.adapter.rxjava2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

@InjectViewState
class AuthPresenter : MvpPresenter<AuthView>() {

    @Inject
    lateinit var interactor: AuthInteractor

    private var login = ""
    private var password = ""

    private var loginDisposable: Disposable? = null

    init {
        App.component.plus(AuthModule()).inject(this)
    }


    // UI Events
    fun onLoginChanged(login: String) {
        this.login = login
        viewState.setLogin(login)
        viewState.setLoginError(null)
    }

    fun onPasswordChanged(password: String) {
        this.password = password
        viewState.setPassword(password)
        viewState.setPasswordError(null)
    }

    fun onLoginButtonClicked() {
        var filedsIsFilled = true

        if (login.isEmpty()) {
            viewState.setLoginError(R.string.login_is_empty)
            filedsIsFilled = false
        }

        if (password.isEmpty()) {
            viewState.setPasswordError(R.string.password_is_empty)
            filedsIsFilled = false
        }

        if (filedsIsFilled) {
            viewState.setLoaderVisibility(true)

            loginDisposable = interactor.login(login, password).subscribe({
                viewState.navigateToMainScreen()
            }, { error ->
                viewState.setLoaderVisibility(false)
                when (error::class) {
                    UnknownHostException::class -> viewState.showError(titleRes = R.string.no_iternet_connection)
                    HttpException::class -> {
                        when ((error as HttpException).code()) {
                            401 -> viewState.showError(titleRes = R.string.bad_credentials)
                            else -> viewState.showError(title = error.message)
                        }
                    }
                    else -> viewState.showError(title = error.localizedMessage)
                }
            })
        }
    }


    // Lifecycle
    override fun onDestroy() {
        loginDisposable?.dispose()
        super.onDestroy()
    }
}