package com.upb.vlibrary

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent

class CompleteListOfUsersViewModel: ViewModel() {
    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun getAllListOfUsers(): Flow<List<UserInfo>> {
        return userRepository.getAllListOfUsers()
    }

}