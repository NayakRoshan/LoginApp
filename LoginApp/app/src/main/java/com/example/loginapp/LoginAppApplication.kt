package com.example.loginapp

import android.app.Application
import io.realm.Realm

class LoginAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}