package com.example.android.dagger.di

import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
        interface SubcomponentFactory {
            fun create(): RegistrationComponent
        }


    fun inject(fragment: TermsAndConditionsFragment)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(activity: RegistrationActivity)

}