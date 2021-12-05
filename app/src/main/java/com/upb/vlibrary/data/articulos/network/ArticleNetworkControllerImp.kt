package com.upb.vlibrary.data.articulos.network
import com.upb.vlibrary.Books
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleNetworkControllerImp:ArticleNetworkController {
    val client= Retrofit.Builder()
        .baseUrl("http://192.168.0.20:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ArticleAPI::class.java)


    override suspend fun getAllBooks(): List<Books> {
        return client.getAllBooks()
    }
}