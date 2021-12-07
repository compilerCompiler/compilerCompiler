package com.upb.vlibrary.data.user.network

import com.upb.vlibrary.data.user.network.model.LoginRequest
import com.upb.vlibrary.data.user.network.model.RegisterRequest
import com.upb.vlibrary.data.user.network.model.ReservationRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/api/user/login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @POST("/api/user/register")
    suspend fun register(@Body registerRequest: RegisterRequest)

    @POST("/api/reservacion/register")
    suspend fun reservacion(@Body reservationRequest: ReservationRequest)
}