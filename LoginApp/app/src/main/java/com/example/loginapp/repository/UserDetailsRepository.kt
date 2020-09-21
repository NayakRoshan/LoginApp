package com.example.loginapp.repository

import com.example.loginapp.localDb.UserDetails
import com.example.loginapp.localDb.RealmConfig
import io.realm.Realm
import io.realm.RealmConfiguration

class UserDetailsRepository {

    private val realmInstance : Realm = Realm.getInstance(RealmConfig.getRealmConfiguration() as RealmConfiguration)

    fun writeUserDetails(
        email : String,
        password : String,
        name : String,
        phone : String,
        age : String
    ) {
        realmInstance.executeTransaction {
            val userDetails = it.createObject(UserDetails::class.java)
            userDetails.email = email
            userDetails.password = password
            userDetails.name = name
            userDetails.phone = phone
            userDetails.age = age
        }
    }

    fun readUserDetails(email : String, password: String) : UserDetails? {
        return realmInstance.where(UserDetails::class.java)
            .equalTo("email", email)
            .and().equalTo("password", password).findFirst()
    }

    fun closeRealm() {
        realmInstance.close()
    }

}