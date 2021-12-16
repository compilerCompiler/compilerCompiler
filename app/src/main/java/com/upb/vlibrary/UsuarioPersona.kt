package com.upb.vlibrary

import java.io.Serializable

data class UsuarioPersona (val Id_persona:Int,
                           val Id_Usuario:Int,
                           val Nombre:String,
                           val Profesion:String,
                           val Nombre_usuario:String,
                           val Password:String,
                           val Correo:String,
                           val Ultimo_Inicio:String):Serializable

