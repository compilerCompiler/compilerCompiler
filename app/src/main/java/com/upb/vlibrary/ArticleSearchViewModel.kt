package com.upb.vlibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.articulos.ArticleRepository
import com.upb.vlibrary.data.articulos.network.ArticleNetworkControllerImp
import com.upb.vlibrary.data.articulos.persistency.ArticlePersistencyControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ArticleSearchViewModel:ViewModel() {

    val articleRepository=ArticleRepository(ArticleNetworkControllerImp(),ArticlePersistencyControllerImp())
    val libros = MutableLiveData<List<Books>>(listOf())

    fun updateListBooks(){
        articleRepository.getBooks().onEach {
            libros.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun updateSelectedBooks(query:String){
        articleRepository.getSelectedBooks(query,query).onEach {
            libros.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}