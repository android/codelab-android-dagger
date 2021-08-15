package com.example.android.dagger.login

import com.example.android.dagger.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

     fun inject(activity: LoginActivity)

}