package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.ui.MainActivity

class SplashActivity : AppCompatActivity() {

    private val LIFESPAN : Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
            val callMainActivity : Intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(callMainActivity)
            this@SplashActivity.finish()
        }, LIFESPAN)
    }
}