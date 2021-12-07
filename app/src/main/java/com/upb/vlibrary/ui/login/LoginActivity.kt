package com.upb.vlibrary.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upb.vlibrary.ui.Extras.NetworkUtils
import com.upb.vlibrary.R

class LoginActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        NetworkUtils.updateIsOnline(this)
    }
}