package com.example.nikitalevcenko.githubapp.settings.auth

import android.content.Context

private const val SETTINGS_NAME = "github_app_settings"

private const val IS_AUTHORIZED = "IS_AUTHORIZED"

class AuthImpl(context: Context) : Auth {

    private val sharedPreferences = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)

    override var isAuthorized: Boolean
        get() = sharedPreferences.getBoolean(IS_AUTHORIZED, false)
        set(value) {
            putBoolean(IS_AUTHORIZED, value)
        }


    private fun putString(key: String, value: String) {
        sharedPreferences.edit()
                .putString(key, value)
                .apply()
    }

    private fun putLong(key: String, value: Long) {
        sharedPreferences.edit()
                .putLong(key, value)
                .apply()
    }

    private fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply()
    }
}