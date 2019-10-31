package com.example.android.dagger.splash

import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(val userManager: UserManager) {

    fun  isUserLoggedIn()  = userManager.isUserLoggedIn()

    fun  isUserRegistered()  = userManager.isUserRegistered()
}