package com.example.loginapp.repository

import com.example.loginapp.entity.UserDetails
import com.example.loginapp.localDb.RealmConfig
import io.realm.Realm
import io.realm.RealmConfiguration

class UserDetailsRepository {

    private val realmInstance : Realm = Realm.getInstance(RealmConfig.getRealmConfiguration() as RealmConfiguration)
    private val EMAIL_FIELD : String = "email"
    private val PASSWORD_FIELD : String = "password"

    fun writeUserDetails(
        email : String,
        password : String,
        name : String,
        phone : String,
        age : String
    ) {
        realmInstance.executeTransaction {
            val userDetails = it.createObject(UserDetails::class.java)
            userDetails.apply {
                this.email = email
                this.password = password
                this.name = name
                this.phone = phone
                this.age = age
            }
        }
    }

    fun readUserDetails(email : String, password: String) : UserDetails? {
        return realmInstance.where(UserDetails::class.java)
            .equalTo(EMAIL_FIELD, email)
            .and().equalTo(PASSWORD_FIELD, password).findFirst()
    }

    fun closeRealm() {
        realmInstance.close()
    }

}