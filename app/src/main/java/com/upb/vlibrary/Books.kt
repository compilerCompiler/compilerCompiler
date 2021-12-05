package com.upb.vlibrary

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Books (@PrimaryKey val Id_libro:Int,
                  val Titulo:String,
                  val Autor:String,
                  val Sinopsis:String,
                  val Foto_url:String,
                  val Estado:Int,
                  val Reservado: Int,
                  val Created: String,
                  val Updated:String):Serializable