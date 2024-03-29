package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoginStorage

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RegistrationStorage

@Module
abstract class StorageModule {

    @Provides
    @RegistrationStorage
    fun provideRegistrationStorage(context: Context): Storage {
        return SharedPreferencesStorage("registration", context)
    }

    @Provides
    @LoginStorage
    fun provideLoginStorage(context: Context): Storage {
        return SharedPreferencesStorage("login", context)
    }

//    @Binds
//    abstract fun provideStorage(sharedPreferencesStorage: SharedPreferencesStorage): Storage


}