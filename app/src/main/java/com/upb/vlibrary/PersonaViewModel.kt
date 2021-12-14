package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class PersonaViewModel:ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun createPersona(nombre:String,profesion:String,id_persona:Int): Flow<Any> {
        return userRepository.createPersona(nombre,profesion,id_persona)
    }
}