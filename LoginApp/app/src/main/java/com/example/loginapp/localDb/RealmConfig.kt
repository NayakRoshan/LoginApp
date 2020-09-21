package com.example.loginapp.localDb

import io.realm.RealmConfiguration

class RealmConfig {

    companion object {
        private var realmConfiguration: RealmConfiguration? = null

        private fun setConfiguration() {
            realmConfiguration = RealmConfiguration.Builder()
                .name("Login.realm")
                .schemaVersion(1)
                .build()
        }

        fun getRealmConfiguration(): RealmConfiguration? {
            if (realmConfiguration == null) {
                setConfiguration()
            }

            return realmConfiguration
        }
    }
}