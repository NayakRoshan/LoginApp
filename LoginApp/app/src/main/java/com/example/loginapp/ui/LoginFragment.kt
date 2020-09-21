package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import com.example.loginapp.localDb.UserDetails
import com.example.loginapp.repository.UserDetailsRepository
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view) //why pass view?
        signIn.setOnClickListener(signInButtonListener)
    }

    private val signInButtonListener = View.OnClickListener {
        val emailEntered : String = email.text.toString()
        val passwordEntered : String = password.text.toString()

        val userDetailsRepository =
            UserDetailsRepository()
        val userDetails : UserDetails? = userDetailsRepository.readUserDetails(emailEntered, passwordEntered)

        if (userDetails == null) {
            Toast.makeText(requireActivity(), "Wrong Email or Password.", Toast.LENGTH_SHORT).show()
            //activity and requireActivity.
        } else {
            val bundle : Bundle = bundleOf(
                "name" to userDetails.name,
                "phone" to userDetails.phone,
                "age" to userDetails.age
            )
            navController.navigate(R.id.action_loginFragment_to_displayDetailsFragment, bundle)
        }
    }

}