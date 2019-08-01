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

package com.example.android.dagger.settings

import com.example.android.dagger.user.UserDataRepository
import com.example.android.dagger.user.UserManager
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SettingsViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var userDataRepository: UserDataRepository
    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        userDataRepository = mock(UserDataRepository::class.java)
        viewModel = SettingsViewModel(userDataRepository, userManager)
    }

    @Test
    fun `Refresh notifications works as expected`() {
        viewModel.refreshNotifications()

        verify(userDataRepository).refreshUnreadNotifications()
    }

    @Test
    fun `Logout works as expected`() {
        viewModel.logout()

        verify(userManager).logout()
    }
}
