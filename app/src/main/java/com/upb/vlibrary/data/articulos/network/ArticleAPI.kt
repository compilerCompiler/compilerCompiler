package com.upb.vlibrary.data.articulos.network

import com.upb.vlibrary.Books
import retrofit2.http.GET

interface ArticleAPI {

    @GET("/api/books/findAll")
    suspend fun getAllBooks():List<Books>
}