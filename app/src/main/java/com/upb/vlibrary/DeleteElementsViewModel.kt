package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class DeleteElementsViewModel:ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun deletePersona(id_persona:Int): Flow<Any> {
        return userRepository.deletePersona(id_persona)
    }

    fun deleteUsuario(id_usuario:Int):Flow<Any>{
        return userRepository.deleteUsuario(id_usuario)
    }
}