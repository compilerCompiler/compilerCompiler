package com.upb.vlibrary.data.articulos.network

import com.upb.vlibrary.Books

interface ArticleNetworkController {
    suspend fun getAllBooks():List<Books>
    suspend fun getSelectionBooks(titulo:String,autor:String):List<Books>
}