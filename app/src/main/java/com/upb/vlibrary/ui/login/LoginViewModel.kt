package com.upb.vlibrary.ui.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.data.user.UserRepository
import com.upb.vlibrary.data.user.network.UserNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response

class LoginViewModel: ViewModel() {

    private val userRepository by inject(UserRepository::class.java)

    fun login(nombre_usuario:String,password:String):Flow<UserInfo>{
        return userRepository.login(nombre_usuario,password)
    }

}