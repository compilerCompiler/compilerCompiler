package com.upb.vlibrary.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.Persona
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class PersonaViewModel:ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun createPersona(nombre:String,profesion:String,id_usuario:Int): Flow<Persona> {
        return userRepository.createPersona(nombre,profesion,id_usuario)
    }
}