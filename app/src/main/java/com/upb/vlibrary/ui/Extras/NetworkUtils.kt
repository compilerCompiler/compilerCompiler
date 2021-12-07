package com.upb.vlibrary.ui.Extras


import android.content.Context
import com.upb.vlibrary.isNetworkConnected

object NetworkUtils {
    var isOnline = false

    fun updateIsOnline(context: Context) {
        isOnline = isNetworkConnected(context)
    }
}