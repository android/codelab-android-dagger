package com.example.android.dagger.splash

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface SplashComponent {

    // Factory to create instances of LoginComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplashActivity)
}
