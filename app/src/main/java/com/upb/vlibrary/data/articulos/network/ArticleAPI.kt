package com.upb.vlibrary.data.articulos.network

import com.upb.vlibrary.Books
import com.upb.vlibrary.data.articulos.network.model.FindSelectionRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticleAPI {

    @GET("/api/books/findAll")
    suspend fun getAllBooks():List<Books>

    @POST("/api/books/findSelection")
    suspend fun getSelectionBooks(@Body findSelectionRequest: FindSelectionRequest):List<Books>
}