package com.upb.vlibrary

import java.io.Serializable

data class UserInfo (val Id_usuario:Int,
                     val Nombre_usuario:String,
                     val Ultimo_inicio:String,
                     val Password:String,
                     val Created:String,
                     val Updated: String):Serializable