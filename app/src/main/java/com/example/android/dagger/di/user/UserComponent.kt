package com.example.android.dagger.di.user

import com.example.android.dagger.di.LoggedUserScope
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.settings.SettingsActivity
import dagger.Subcomponent

@LoggedUserScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun userSubComponent(): UserComponent.Factory

    fun inject(activity: SettingsActivity)
    fun inject(activity: MainActivity)
}