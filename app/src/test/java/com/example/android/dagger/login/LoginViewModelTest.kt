/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.dagger.LiveDataTestUtil
import com.example.android.dagger.user.UserManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

class LoginViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: LoginViewModel
    private lateinit var userManager: UserManager

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        sut = LoginViewModel(userManager)
    }

    @Test
    fun `Get username`() {
        whenever(userManager.username).thenReturn("Username")

        val username = sut.getUsername()

        assertEquals("Username", username)
    }

    @Test
    fun `Login emits success`() {
        whenever(userManager.loginUser(anyString(), anyString())).thenReturn(true)

        sut.login("username", "login")

        assertEquals(LiveDataTestUtil.getValue(sut.loginState), LoginSuccess)
    }

    @Test
    fun `Login emits error`() {
        whenever(userManager.loginUser(anyString(), anyString())).thenReturn(false)

        sut.login("username", "login")

        assertEquals(LiveDataTestUtil.getValue(sut.loginState), LoginError)
    }
}
