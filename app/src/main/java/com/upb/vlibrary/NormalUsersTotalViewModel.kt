package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class NormalUsersTotalViewModel:ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun getNormalUsers(): Flow<List<UsuarioPersona>> {
        return userRepository.getAllUsers()
    }
}