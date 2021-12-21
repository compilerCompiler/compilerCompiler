package com.upb.vlibrary.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.upb.vlibrary.UserInfo
import com.upb.vlibrary.data.user.UserRepository
import kotlinx.coroutines.flow.Flow
import org.koin.java.KoinJavaComponent

class CompleteListOfUsersViewModel: ViewModel() {
    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun getAllListOfUsers(): Flow<List<UserInfo>> {
        return userRepository.getAllListOfUsers()
    }

}