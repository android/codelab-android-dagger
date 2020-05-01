package com.example.android.dagger.splash

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent

// Scope annotation that the SplashComponent uses
// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface SplashComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplashActivity)
}