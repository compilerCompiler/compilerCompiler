package com.upb.vlibrary

import java.io.Serializable

data class Video(val Id_video:Int,
                 val Duracion:String,
                 val Enlace:String,
                 val Calidad:String,
                 val Created:String,
                 val Updated:String,
                 val Miniatura:String,
                 val Titulo:String): Serializable