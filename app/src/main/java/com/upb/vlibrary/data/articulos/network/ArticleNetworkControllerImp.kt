package com.upb.vlibrary.data.articulos.network
import com.upb.vlibrary.Books
import com.upb.vlibrary.data.articulos.network.model.FindSelectionRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleNetworkControllerImp:ArticleNetworkController {
    val client= Retrofit.Builder()
        .baseUrl("https://vlibrary-official.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ArticleAPI::class.java)


    override suspend fun getAllBooks(): List<Books> {
        return client.getAllBooks()
    }

    override suspend fun getSelectionBooks(titulo: String, autor: String): List<Books> {
        return client.getSelectionBooks(FindSelectionRequest(titulo,autor))
    }
}