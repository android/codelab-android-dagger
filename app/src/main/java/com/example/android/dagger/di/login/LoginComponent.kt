package com.example.android.dagger.di.login

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.login.LoginActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface SubcomponentFactory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
}