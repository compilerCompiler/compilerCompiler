package com.upb.vlibrary.data.multimedia

import com.upb.vlibrary.Video
import com.upb.vlibrary.data.multimedia.network.MultimediaNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MultimediaRepository(val network: MultimediaNetworkController) {

    fun getAllVideos(): Flow<List<Video>> {
        return flow{
            emit(network.getAllVideos())
        }
    }
}