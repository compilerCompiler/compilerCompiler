package com.upb.vlibrary.ui.reservation

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class ReservationViewModel: ViewModel() {

    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun reservation(id_usuario:Int,id_libro:Int,fecha_reservacion:String,fecha_devolucion:String): Flow<Any> {
        return userRepository.reservation(id_usuario,id_libro,fecha_reservacion,fecha_devolucion)
    }
}