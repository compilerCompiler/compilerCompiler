package com.upb.vlibrary.data.articulos

import android.util.Log
import com.upb.vlibrary.Books
import com.upb.vlibrary.data.articulos.network.ArticleNetworkController
import com.upb.vlibrary.data.articulos.persistency.ArticlePersistencyController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class ArticleRepository(
    private val network: ArticleNetworkController,
    private val persistency: ArticlePersistencyController
) {

    fun getBooks(): Flow<List<Books>> {
        return flow {
            emit(persistency.getAllbooks())
            try {
                val libros = network.getAllBooks()
                persistency.saveBooks(libros)
                emit(libros)
            }catch (e:Exception){
                Log.e("ERROR",e.message!!)
            }
        }
    }

}