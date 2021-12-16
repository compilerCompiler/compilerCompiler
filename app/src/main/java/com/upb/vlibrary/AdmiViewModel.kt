package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class AdmiViewModel:ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun createAdmi(id_persona:Int,codigo_admi:Int): Flow<Any> {
        return userRepository.createAdmi(id_persona,codigo_admi)
    }

    fun getAdmi(id_usuario:Int):Flow<Any>{
        return userRepository.getAdmi(id_usuario)
    }
}