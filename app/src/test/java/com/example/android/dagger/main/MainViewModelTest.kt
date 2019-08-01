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

package com.example.android.dagger.main

import com.example.android.dagger.user.UserDataRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

class MainViewModelTest {

    private lateinit var userDataRepository: UserDataRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        userDataRepository = mock(UserDataRepository::class.java)
        viewModel = MainViewModel(userDataRepository)
    }

    @Test
    fun `Welcome text returns right text`() {
        whenever(userDataRepository.username).thenReturn("username")

        assertEquals("Hello username!", viewModel.welcomeText)
    }

    @Test
    fun `Notifications text returns right text`() {
        whenever(userDataRepository.unreadNotifications).thenReturn(5)

        assertEquals("You have 5 unread notifications", viewModel.notificationsText)
    }
}
