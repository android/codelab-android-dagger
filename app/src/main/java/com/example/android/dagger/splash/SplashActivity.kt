package com.example.android.dagger.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.dagger.MyApplication
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        // Creates an instance of Splash component by grabbing the factory from the app graph
        // and injects this activity to that Component
        (application as MyApplication).appComponent.splashComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        showActivity()
    }

    private fun showActivity() {
        val activity = splashViewModel.getActivityClass()
        startActivity(Intent(this, activity))
        finish()
    }
}
