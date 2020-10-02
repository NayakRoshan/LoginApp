package com.example.loginapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_main.*

class SignUpOrLoginFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        setSignUpButtonListener()
        setLoginButtonListener()
    }

    private fun setSignUpButtonListener() {
        signUp.setOnClickListener { navController.navigate(R.id.action_mainFragment_to_newUserLoginDetailsFragment) }
    }

    private fun setLoginButtonListener() {
        login.setOnClickListener { navController.navigate(R.id.action_mainFragment_to_loginFragment) }
    }
}