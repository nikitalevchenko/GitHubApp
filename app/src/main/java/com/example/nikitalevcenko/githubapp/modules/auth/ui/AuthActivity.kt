package com.example.nikitalevcenko.githubapp.modules.auth.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikitalevcenko.githubapp.R
import com.example.nikitalevcenko.githubapp.modules.auth.presentation.AuthPresenter
import com.example.nikitalevcenko.githubapp.modules.auth.view.AuthView
import com.example.nikitalevcenko.githubapp.base.ui.ActivityBase
import com.example.nikitalevcenko.githubapp.base.ui.KeyboardUtil
import com.example.nikitalevcenko.githubapp.base.ui.addTextChangedListener
import com.example.nikitalevcenko.githubapp.base.ui.setVisibility
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : ActivityBase(), AuthView {

    @InjectPresenter
    lateinit var presenter: AuthPresenter

    private val keyboardUtil by lazy { KeyboardUtil(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        logInButton.setOnClickListener {
            presenter.onLoginButtonClicked()
        }
        loginEditText.addTextChangedListener { presenter.onLoginChanged(it) }
        passwordEditText.addTextChangedListener { presenter.onPasswordChanged(it) }
    }

    override fun setLogin(login: String) {
        if (loginEditText.text.toString() != login) {
            loginEditText.setText(login)
        }
    }

    override fun setPassword(password: String) {
        if (passwordEditText.text.toString() != password) {
            passwordEditText.setText(password)
        }
    }

    override fun setLoginError(errorRes: Int?) {
        loginTextInputLayout.error = errorRes?.let { getString(it) }
    }

    override fun setPasswordError(errorRes: Int?) {
        passwordTextInputLayout.error = errorRes?.let { getString(it) }
    }

    override fun setLoaderVisibility(visible: Boolean) {
        if (visible) {
            keyboardUtil.hideKeyboard()
        }
        progressBarFrameLayout.setVisibility(visible)
        logInButton.isEnabled = !visible
        loginEditText.isEnabled = !visible
        passwordEditText.isEnabled = !visible
    }

    override fun navigateToMainScreen() {
        // TODO
    }
}
