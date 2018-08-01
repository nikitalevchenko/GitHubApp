package com.example.nikitalevcenko.githubapp

import android.arch.persistence.room.Room
import android.content.Context
import android.support.annotation.NonNull
import com.example.nikitalevcenko.githubapp.api.Api
import com.example.nikitalevcenko.githubapp.api.BASE_URL
import com.example.nikitalevcenko.githubapp.db.DB
import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepo
import com.example.nikitalevcenko.githubapp.repo.auth.AuthRepoImpl
import com.example.nikitalevcenko.githubapp.settings.Settings
import com.example.nikitalevcenko.githubapp.settings.auth.AuthImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Context) {

    @Provides
    @Singleton
    fun context() = appContext

    @Provides
    @NonNull
    @Singleton
    fun api(): Api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

    @Provides
    @NonNull
    @Singleton
    fun settings(context: Context): Settings = object : Settings {
        override val auth = AuthImpl(context)
    }

    @Provides
    @NonNull
    @Singleton
    fun db(context: Context): DB {
        return Room.databaseBuilder(context, DB::class.java, "database.db").build()
    }

    // Repos
    @Provides
    @NonNull
    @Singleton
    fun authRepo(api: Api, settings: Settings, db: DB): AuthRepo = AuthRepoImpl(api, settings, db)
}