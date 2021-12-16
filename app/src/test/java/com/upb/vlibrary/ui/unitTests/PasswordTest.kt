package com.upb.vlibrary.ui.unitTests

import com.google.common.truth.Truth.assertThat
import com.upb.vlibrary.ui.register.RegisterFragment
import org.junit.Test

class PasswordTest {
    @Test
    fun `empty password returns false`(){
        val result = RegisterFragment().validatePasswordInput(
            ""
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegisterFragment().validatePasswordInput(
            "Philipp"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `correct password returns true`() {
        val result = RegisterFragment().validateUsernameInput(
            "Contraseña123"
        )
        assertThat(result).isTrue()
    }

}