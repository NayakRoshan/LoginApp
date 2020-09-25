package com.example.loginapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginapp.R
import com.example.loginapp.repository.UserDetailsRepository
import kotlinx.android.synthetic.main.fragment_new_user_login_details.*

class SignUpViewModel : ViewModel() {
    private val mUserEmail : MutableLiveData<String> by lazy { MutableLiveData<String>() }
    private val mUserPassword : MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun setUserEmail(email : String) {
        mUserEmail.value = email
    }

    fun setUserPassword(password : String) {
        mUserPassword.value = password
    }

    fun writeToDatabase(
        name : String,
        phone : String,
        age : String
    ) {
        val userDetailsRepository = UserDetailsRepository()
        userDetailsRepository.writeUserDetails(mUserEmail.value.toString(), mUserPassword.value.toString(), name, phone, age)
    }

}