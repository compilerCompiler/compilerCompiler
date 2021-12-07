package com.upb.vlibrary.ui.login

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent.inject

class LoginViewModel: ViewModel() {
    private val userRepository by inject(UserRepository::class.java)

    fun login(nombre_usuario:String,password:String): Flow<Any> {
        return userRepository.login(nombre_usuario,password)
    }
}