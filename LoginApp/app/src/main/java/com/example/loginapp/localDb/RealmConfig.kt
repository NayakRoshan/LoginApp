package com.example.loginapp.localDb

import io.realm.RealmConfiguration

class RealmConfig {

    companion object {
        private var realmConfiguration: RealmConfiguration? = null
        private const val REALM_FILE_NAME = "Login.realm"

        private fun setConfiguration() {
            realmConfiguration = RealmConfiguration.Builder()
                .name(REALM_FILE_NAME)
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