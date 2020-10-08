package com.example.loginapp.localDb

import com.example.loginapp.entity.UserDetails
import io.realm.Realm
import io.realm.RealmConfiguration

object RealmUserDetailsOperation {

    private var realmInstance : Realm = Realm.getInstance(RealmConfig.getRealmConfiguration() as RealmConfiguration)
    private val EMAIL_FIELD : String = "email"
    private val PASSWORD_FIELD : String = "password"

    fun writeUserDetailsToRealm(
        email : String,
        password : String,
        name : String,
        phone : String,
        age : String
    ) {
        if (realmInstance.isClosed) {
            realmInstance = Realm.getInstance(RealmConfig.getRealmConfiguration() as RealmConfiguration)
        }
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

    fun readUserDetailsFromRealm(email : String, password: String) : UserDetails? {
        if (realmInstance.isClosed) {
            realmInstance = Realm.getInstance(RealmConfig.getRealmConfiguration() as RealmConfiguration)
        }
        return realmInstance.where(UserDetails::class.java)
            .equalTo(EMAIL_FIELD, email)
            .and().equalTo(PASSWORD_FIELD, password).findFirst()
    }

    fun closeRealmInstance() {
        realmInstance.close()
    }

}