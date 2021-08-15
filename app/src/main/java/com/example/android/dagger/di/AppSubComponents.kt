package com.example.android.dagger.di

import com.example.android.dagger.registration.RegistrationComponent
import dagger.Module
import dagger.Subcomponent


@Module(subcomponents = [RegistrationComponent::class])
class AppSubComponents {

}