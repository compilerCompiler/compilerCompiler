package com.upb.vlibrary.data.user.network

import com.upb.vlibrary.data.user.network.model.LoginRequest
import com.upb.vlibrary.data.user.network.model.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp:UserNetworkController {
    val client=Retrofit.Builder()
        .baseUrl("http://192.168.0.20:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)



    override suspend fun login(nombre_usuario: String, password: String) {
        return client.login(LoginRequest(nombre_usuario,password))
    }

    override suspend fun register(nombre_usuario: String, correo: String, password: String) {
        return client.register(RegisterRequest(nombre_usuario,correo,password))
    }
}