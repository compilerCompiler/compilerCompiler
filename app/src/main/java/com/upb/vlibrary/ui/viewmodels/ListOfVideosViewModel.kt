package com.upb.vlibrary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upb.vlibrary.Video
import com.upb.vlibrary.data.multimedia.MultimediaRepository
import com.upb.vlibrary.data.multimedia.network.MultimediaNetworkControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListOfVideosViewModel: ViewModel() {

    val videoRepository= MultimediaRepository(MultimediaNetworkControllerImp())
    val videos = MutableLiveData<List<Video>>(listOf())

    fun updateVideos(){
        videoRepository.getAllVideos().onEach {
            videos.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}