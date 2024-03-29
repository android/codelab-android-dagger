package com.example.android.dagger.di

import com.example.android.dagger.di.login.LoginComponent
import com.example.android.dagger.di.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubcomponents {
}