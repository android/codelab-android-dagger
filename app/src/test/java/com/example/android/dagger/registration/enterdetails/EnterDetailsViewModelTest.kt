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

package com.example.android.dagger.registration.enterdetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.dagger.shared_test.LiveDataTestUtil
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EnterDetailsViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: EnterDetailsViewModel

    @Before
    fun setup() {
        viewModel = EnterDetailsViewModel()
    }

    @Test
    fun `ValidateInput gives error when username is invalid`() {
        viewModel.validateInput("user", "password")

        assertTrue(com.example.android.dagger.shared_test.LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsError)
    }

    @Test
    fun `ValidateInput gives error when password is invalid`() {
        viewModel.validateInput("username", "pass")

        assertTrue(com.example.android.dagger.shared_test.LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsError)
    }

    @Test
    fun `ValidateInput succeeds when input is valid`() {
        viewModel.validateInput("username", "password")

        assertTrue(com.example.android.dagger.shared_test.LiveDataTestUtil.getValue(viewModel.enterDetailsState) is EnterDetailsSuccess)
    }
}
