package com.upb.vlibrary.data.user.network

import com.upb.vlibrary.Persona
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.UserRegistered
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.data.user.network.model.*
import retrofit2.http.*

interface UserAPI {
    @POST("/api/user/login")
    suspend fun login(@Body loginRequest: LoginRequest):UserInfo

    @POST("/api/user/register")
    suspend fun register(@Body registerRequest: RegisterRequest):UserRegistered

    @POST("/api/reservacion/register")
    suspend fun reservacion(@Body reservationRequest: ReservationRequest)

    @POST("/api/personas/create")
    suspend fun createPersona(@Body personaRequest: PersonaRequest):Persona

    @POST("api/administrador/create")
    suspend fun createAdmi(@Body admiRequest: AdmiRequest)

    @GET("api/personas/findAll")
    suspend fun getAllUsers():List<UsuarioPersona>

    @DELETE("api/personas/{id}")
    suspend fun deletePersona(@Path("id") id_persona:Int)

    @DELETE("api/user/{id}")
    suspend fun deleteUsuario(@Path("id") id_usuario:Int)

    @GET("api/administrador/{id}")
    suspend fun getAdmi(@Path("id") id_usuario: Int)
}