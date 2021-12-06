package com.upb.vlibrary.data.articulos.persistency

import com.upb.vlibrary.Books

interface ArticlePersistencyController {
    fun getAllbooks():List<Books>
    fun saveBooks(books: List<Books>)
    fun filterBooksByDisponibilidad(disponibilidadCheck: Boolean):List<Books>
    fun getAllSelectedBooks(titulo:String,autor:String):List<Books>

}