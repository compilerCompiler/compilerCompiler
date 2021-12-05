package com.upb.vlibrary.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.upb.vlibrary.Books

@Dao
interface ArticleDao {

    @Query("SELECT * FROM books")
    fun getAllBooks():List<Books>

    @Insert
    fun saveBooks(books: List<Books>)

    @Query("SELECT * FROM books WHERE Reservado LIKE :query ")
    fun filterBooksByDisponibility(query: Boolean):List<Books>
}