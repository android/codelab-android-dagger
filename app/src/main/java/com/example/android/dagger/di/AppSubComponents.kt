package com.example.android.dagger.di

import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.registration.RegistrationComponent
import dagger.Module
import dagger.Subcomponent


@Module(subcomponents = [RegistrationComponent::class,LoginComponent::class])
class AppSubComponents {

}