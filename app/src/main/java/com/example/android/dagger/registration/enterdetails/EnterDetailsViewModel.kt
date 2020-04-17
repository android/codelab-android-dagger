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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

private const val MIN_LENGTH = 1

/**
 * EnterDetailsViewModel is the ViewModel that [EnterDetailsFragment] uses to
 * obtain to validate user's input data.
 */
class EnterDetailsViewModel {

    private val _enterDetailsState = MutableLiveData<EnterDetailsViewState>()
    val enterDetailsState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState

    fun validateInput(username: String, password: String) {
        when {
            username.length < MIN_LENGTH -> _enterDetailsState.value =
                EnterDetailsError("Username has to be longer than $MIN_LENGTH characters")
            password.length < MIN_LENGTH -> _enterDetailsState.value =
                EnterDetailsError("Password has to be longer than $MIN_LENGTH characters")
            else -> _enterDetailsState.value = EnterDetailsSuccess
        }
    }
}
