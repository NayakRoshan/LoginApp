package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
        setSignInButtonListener()
    }

    private val signInButtonListener = View.OnClickListener {
        val emailEntered : String = email.text.toString()
        val passwordEntered : String = password.text.toString()

        val userDetails = loginViewModel.readFromDatabase(emailEntered, passwordEntered)
        if (userDetails == null) {
            Toast.makeText(requireActivity(), "Wrong Email or Password.", Toast.LENGTH_SHORT).show()
        } else {
            navController.navigate(R.id.action_loginFragment_to_displayDetailsFragment)
        }
    }

    private fun setSignInButtonListener() {
        signIn.setOnClickListener(signInButtonListener)
    }

}