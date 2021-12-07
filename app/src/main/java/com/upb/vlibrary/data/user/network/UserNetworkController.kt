package com.upb.vlibrary.data.user.network

interface UserNetworkController {
    suspend fun login(username:String, password:String)
    suspend fun register(username: String,email:String,password:String)
    suspend fun reservation(id_usuario:Int,id_libro:Int,fecha_reservacion:String,fecha_devolucion:String)
}