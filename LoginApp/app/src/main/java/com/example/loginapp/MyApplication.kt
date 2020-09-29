package com.example.loginapp

import android.app.Application
import android.content.res.Configuration
import com.example.loginapp.repository.UserDetailsRepository
import io.realm.Realm

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        UserDetailsRepository().closeRealm()
    }
}