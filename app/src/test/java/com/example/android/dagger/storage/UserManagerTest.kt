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

package com.example.android.dagger.storage

import com.example.android.dagger.user.UserManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UserManagerTest {

    private lateinit var storage: Storage
    private lateinit var sut: UserManager

    @Before
    fun setup() {
        storage = FakeStorage()
        sut = UserManager(storage)
    }

    @Test
    fun `Username returns what is in the storage`() {
        assertEquals("", sut.username)

        sut.registerUser("username", "password")

        assertEquals("username", sut.username)
    }

    @Test
    fun `IsUserRegistered behaves as expected`() {
        assertFalse(sut.isUserRegistered())

        sut.registerUser("username", "password")

        assertTrue(sut.isUserRegistered())
    }

    @Test
    fun `Register user adds username and password to the storage`() {
        assertFalse(sut.isUserRegistered())
        assertFalse(sut.isUserLoggedIn())

        sut.registerUser("username", "password")

        assertTrue(sut.isUserRegistered())
        assertTrue(sut.isUserLoggedIn())
        assertEquals("username", storage.getString("registered_user"))
        assertEquals("password", storage.getString("usernamepassword"))
    }

    @Test
    fun `Login succeeds when username is registered and password is correct`() {
        sut.registerUser("username", "password")
        sut.logout()

        assertTrue(sut.loginUser("username", "password"))
        assertTrue(sut.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is not registered`() {
        sut.registerUser("username", "password")
        sut.logout()

        assertFalse(sut.loginUser("username2", "password"))
        assertFalse(sut.isUserLoggedIn())
    }

    @Test
    fun `Login fails when username is registered but password is incorrect`() {
        sut.registerUser("username", "password")
        sut.logout()

        assertFalse(sut.loginUser("username", "password2"))
        assertFalse(sut.isUserLoggedIn())
    }
}
