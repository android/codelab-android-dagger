package com.example.android.dagger.splash

import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

/**
 * SplashViewModel is the ViewModel that [SplashActivity] uses to
 * obtain information of what Activity to show on the screen.
 *
 * @Inject tells Dagger how to provide instances of this type. Dagger also knows
 * that UserManager is a dependency.
 */
class SplashViewModel @Inject constructor(private val userManager: UserManager) {

    /**
     * If the User is not registered, RegistrationActivity will be returned,
     * If the User is not logged in, LoginActivity will be returned,
     * else MainActivity.
     */
    fun getActivityClass(): Class<out AppCompatActivity> =
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                RegistrationActivity::class.java
            } else {
                LoginActivity::class.java
            }
        } else {
            MainActivity::class.java
        }
}