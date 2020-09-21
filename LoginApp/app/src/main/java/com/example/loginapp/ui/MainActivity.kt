package com.example.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.R
import com.example.loginapp.repository.UserDetailsRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        val userDetailsRepository =
            UserDetailsRepository()
        userDetailsRepository.closeRealm()
    }
}