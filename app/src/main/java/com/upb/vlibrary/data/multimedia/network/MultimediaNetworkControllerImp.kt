package com.upb.vlibrary.data.multimedia.network

import com.upb.vlibrary.Video
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MultimediaNetworkControllerImp: MultimediaNetworkController {
    val client= Retrofit.Builder()
        .baseUrl("https://vlibrary-official.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MultimediaAPI::class.java)

    override suspend fun getAllVideos(): List<Video> {
        return client.getAllVideos()
    }

}