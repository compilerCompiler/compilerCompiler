package com.upb.vlibrary.data.multimedia.network

import com.upb.vlibrary.Video
import retrofit2.http.GET

interface MultimediaAPI {

    @GET("api/videos/findAll")
    suspend fun getAllVideos():List<Video>
}