package com.example.nikitalevcenko.githubapp.settings.auth

import android.content.Context

private const val SETTINGS_NAME = "github_app_settings"

private const val ACCESS_TOKEN = "ACCESS_TOKEN"

class AuthImpl(context: Context) : Auth {

    private val sharedPreferences = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)

    override val hasAccessToken: Boolean
        get() = sharedPreferences.contains(ACCESS_TOKEN)


    override var id: Long
        get() = sharedPreferences.getLong(ACCESS_TOKEN, 0)
        set(value) {
            putLong(ACCESS_TOKEN, value)
        }


    override var accessToken: String
        get() = sharedPreferences.getString(ACCESS_TOKEN, "")
        set(value) {
            putString(ACCESS_TOKEN, value)
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
}