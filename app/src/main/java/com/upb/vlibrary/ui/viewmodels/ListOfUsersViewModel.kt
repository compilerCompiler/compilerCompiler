package com.upb.vlibrary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.vlibrary.UsuarioPersona
import com.upb.vlibrary.data.user.UserRepository
import com.upb.vlibrary.data.user.network.UserNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListOfUsersViewModel :ViewModel(){

    val userRepository= UserRepository(UserNetworkControllerImp())
    val users = MutableLiveData<List<UsuarioPersona>>(listOf())

    fun updateListUsers(){
        userRepository.getAllUsers().onEach {
            users.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }


}