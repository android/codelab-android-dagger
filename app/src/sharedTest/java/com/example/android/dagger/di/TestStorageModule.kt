package com.example.android.dagger.di

import com.example.android.dagger.storage.FakeStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class TestStorageModule {

    @Binds
    abstract fun fakeStorage(fakeStorage: FakeStorage): Storage
}