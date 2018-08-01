package com.example.nikitalevcenko.githubapp.repo.auth

import com.example.nikitalevcenko.githubapp.api.Api
import com.example.nikitalevcenko.githubapp.api.NOTE
import com.example.nikitalevcenko.githubapp.db.DB
import com.example.nikitalevcenko.githubapp.settings.Settings
import io.reactivex.Completable
import okhttp3.Credentials

class AuthRepoImpl(private val api: Api, private val settings: Settings, private val db: DB) : AuthRepo {

    override val isAuthorized: Boolean
        get() = settings.auth.isAuthorized

    override fun login(login: String, password: String): Completable {
        val credentials = Credentials.basic(login, password)

        return api.authorizations(credentials)
                .flatMapCompletable { authorizations ->
                    return@flatMapCompletable authorizations.find { authorization -> authorization.note == NOTE }?.id?.let { id -> api.removeAuthorization(credentials, id) }
                            ?: Completable.complete()
                }.andThen(api.login(credentials)).doOnSuccess { authorization ->
                    db.runInTransaction {
                        db.authorizationDao.insertOrReplace(authorization)
                    }
                    settings.auth.isAuthorized = true
                }.ignoreElement()
    }
}