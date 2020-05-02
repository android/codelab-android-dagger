package com.example.android.dagger.splash

import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

class SplashViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var viewModel: SplashViewModel

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        viewModel = SplashViewModel(userManager)
    }

    @Test
    fun `If the user is not registered then getActivityClass returns RegistrationActivity`() {
        whenever(userManager.isUserRegistered()).thenReturn(false)

        assertEquals(RegistrationActivity::class.java, viewModel.getActivityClass())
    }

    @Test
    fun `If the user is registered but not logged in then getActivityClass returns LoginActivity`() {
        whenever(userManager.isUserRegistered()).thenReturn(true)
        whenever(userManager.isUserLoggedIn()).thenReturn(false)

        assertEquals(LoginActivity::class.java, viewModel.getActivityClass())
    }

    @Test
    fun `If the user is logged in then getActivityClass returns MainActivity`() {
        whenever(userManager.isUserLoggedIn()).thenReturn(true)

        assertEquals(MainActivity::class.java, viewModel.getActivityClass())
    }
}