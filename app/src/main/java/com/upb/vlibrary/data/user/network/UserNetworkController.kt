package com.upb.vlibrary.data.user.network


import com.upb.vlibrary.Persona
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.UserRegistered


interface UserNetworkController {
    suspend fun login(username:String, password:String):UserInfo
    suspend fun register(username: String,email:String,password:String):UserRegistered
    suspend fun reservation(id_usuario:Int,id_libro:Int,fecha_reservacion:String,fecha_devolucion:String)
    suspend fun createPersona(nombre:String,profesion:String,id_usuario:Int):Persona
    suspend fun createAdmi(id_persona:Int,codigo_admi:Int)
}