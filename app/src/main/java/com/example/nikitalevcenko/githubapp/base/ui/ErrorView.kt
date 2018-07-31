package com.example.nikitalevcenko.githubapp.base.ui

import android.support.annotation.StringRes

interface ErrorView {
    fun showError(title: String? = null,
                  message: String? = null,
                  onOkListener: (() -> Unit)? = null,
                  onDismissListener: () -> Unit = { showError(title = null) },
                  cancelable: Boolean = true)

    fun showError(@StringRes titleRes: Int? = null,
                  @StringRes messageRes: Int? = null,
                  onOkListener: (() -> Unit)? = null,
                  onDismissListener: () -> Unit = { showError(titleRes = null) },
                  cancelable: Boolean = true)
}