package com.upb.vlibrary.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.upb.vlibrary.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed( {
            val intent  =  Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000 )
    }
}