package com.example.nikitalevcenko.githubapp.base.ui

import android.support.v7.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.nikitalevcenko.githubapp.R

abstract class ActivityBase : MvpAppCompatActivity(), ErrorView {
    override fun showError(titleRes: Int?, messageRes: Int?, onOkListener: (() -> Unit)?, onDismissListener: () -> Unit, cancelable: Boolean) {
        showError(titleRes?.let { getString(it) }, messageRes?.let { getString(it) }, onOkListener, onDismissListener, cancelable)
    }

    override fun showError(title: String?, message: String?, onOkListener: (() -> Unit)?, onDismissListener: () -> Unit, cancelable: Boolean) {
        if (title != null || message != null) {
            AlertDialog.Builder(this)
                    .setPositiveButton(R.string.ok) { dialog, _ ->
                        dialog.dismiss()
                        onOkListener?.invoke()
                    }
                    .setCancelable(cancelable)
                    .setOnDismissListener { onDismissListener() }
                    .apply {
                        title?.let {
                            setTitle(it)
                        }
                        message?.let {
                            setMessage(it)
                        }
                    }
                    .show()
        }
    }
}