package com.upb.vlibrary.data.multimedia.network

import com.upb.vlibrary.Video

interface MultimediaNetworkController {
    suspend fun getAllVideos():List<Video>
}