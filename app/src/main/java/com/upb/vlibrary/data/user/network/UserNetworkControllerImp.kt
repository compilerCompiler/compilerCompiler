package com.upb.vlibrary.data.user.network

import com.upb.vlibrary.Persona
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.UserRegistered
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.data.user.network.model.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp:UserNetworkController {
    val client=Retrofit.Builder()
        .baseUrl("http://192.168.0.20:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    override suspend fun login(nombre_usuario: String, password: String):UserInfo {
        return client.login(LoginRequest(nombre_usuario,password))
    }

    override suspend fun register(nombre_usuario: String, correo: String, password: String):UserRegistered {
        return client.register(RegisterRequest(nombre_usuario,correo,password))
    }

    override suspend fun reservation(id_usuario: Int, id_libro: Int, fecha_reservacion: String, fecha_devolucion: String) {
        return client.reservacion(ReservationRequest(id_usuario,id_libro,fecha_reservacion,fecha_devolucion))
    }

    override suspend fun createPersona(nombre: String, profesion: String, id_usuario: Int):Persona {
        return client.createPersona(PersonaRequest(nombre,profesion,id_usuario))
    }

    override suspend fun createAdmi(id_persona: Int, codigo_admi: Int) {
        return client.createAdmi(AdmiRequest(id_persona,codigo_admi))
    }

    override suspend fun getAllUsers(): List<UsuarioPersona> {
        return client.getAllUsers()
    }

    override suspend fun deletePersona(id_persona: Int) {
        return client.deletePersona(id_persona)
    }

    override suspend fun deleteUsuario(id_usuario: Int) {
        return client.deleteUsuario(id_usuario)
    }

    override suspend fun getAdmi(id_usuario: Int) {
        return client.getAdmi(id_usuario)
    }

    override suspend fun getAllListOfUsers(): List<UserInfo> {
        return client.getAllListOfUsers()
    }
}