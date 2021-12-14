package com.upb.vlibrary

import java.io.Serializable

data class UserRegistered (val id:Int,
                           val nombre_usuario:String,
                           val password:String,
                           val correo:String,
                           val ultimo_inicio:String,
                           val created:String,
                           val updated:String ):Serializable

