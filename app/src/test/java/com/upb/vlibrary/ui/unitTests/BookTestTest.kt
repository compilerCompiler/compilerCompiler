package com.upb.vlibrary.ui.unitTests

import com.google.common.truth.Truth.assertThat
import com.upb.vlibrary.ui.search.ArticleSearchInfoFragment
import org.junit.Test

class BookTestTest {
    @Test
    fun `empty book title returns false`() {
        val result = ArticleSearchInfoFragment().validateBookTitle(
            ""
        )
        assertThat(result).isFalse()

    }

    @Test
    fun `book does not exists returns false`() {
        val result = ArticleSearchInfoFragment().validateBookTitle(
            "Historia de Bolivia 2"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `correct book returns true`() {
        val result = ArticleSearchInfoFragment().validateBookTitle(
            "Historia de Bolivia"
        )
        assertThat(result).isTrue()
    }
}