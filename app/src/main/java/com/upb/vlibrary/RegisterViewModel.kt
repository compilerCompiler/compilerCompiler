package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent.inject


class RegisterViewModel: ViewModel() {


    private val userRepository by inject(UserRepository::class.java)

    fun register (username:String,email:String,password:String): Flow<Any> {
        return userRepository.register(username,email,password)
    }
}