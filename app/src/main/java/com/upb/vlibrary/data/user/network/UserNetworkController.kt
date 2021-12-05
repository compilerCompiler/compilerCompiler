package com.upb.vlibrary.data.user.network

interface UserNetworkController {
    suspend fun login(username:String, password:String)
    suspend fun register(username: String,email:String,password:String)
}