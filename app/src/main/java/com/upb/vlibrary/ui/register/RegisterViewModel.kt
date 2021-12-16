package com.upb.vlibrary.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.UserRegistered
import com.upb.vlibrary.data.user.UserRepository
import com.upb.vlibrary.data.user.network.UserNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject


class RegisterViewModel: ViewModel() {

    private val userRepository by inject(UserRepository::class.java)

    fun register (username:String,email:String,password:String): Flow<UserRegistered> {
        return userRepository.register(username,email,password)
    }
}