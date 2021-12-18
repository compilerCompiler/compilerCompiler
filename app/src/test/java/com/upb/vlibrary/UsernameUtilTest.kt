package com.upb.vlibrary

import com.google.common.truth.Truth.assertThat
import com.upb.vlibrary.ui.register.RegisterFragment
import org.junit.Test

class UsernameUtilTest{

    @Test
    fun `empty username returns false`() {
        val result = RegisterFragment().validateUsernameInput(
            ""
        )
        assertThat(result).isFalse()

    }

    @Test
    fun `username already exists returns false`() {
        val result = RegisterFragment().validateUsernameInput(
            "Manuel"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `correct username returns true`() {
        val result = RegisterFragment().validateUsernameInput(
            "Luciano"
        )
        assertThat(result).isTrue()
    }


}