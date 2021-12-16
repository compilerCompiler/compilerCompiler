package com.upb.vlibrary.ui.unitTests

import com.google.common.truth.Truth.assertThat
import com.upb.vlibrary.ui.search.ArticleSearchInfoFragment
import org.junit.Test

class BookAuthorTest {
    @Test
    fun `empty author title returns false`() {
        val result = ArticleSearchInfoFragment().validateBookAuthor(
            ""
        )
        assertThat(result).isFalse()

    }

    @Test
    fun `author does not exists returns false`() {
        val result = ArticleSearchInfoFragment().validateBookAuthor(
            "Juan Perez"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `correct author returns true`() {
        val result = ArticleSearchInfoFragment().validateBookAuthor(
            "Alcides Arguedas"
        )
        assertThat(result).isTrue()
    }

}