package com.example.loginapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.loginapp.R
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var navController: NavController
    private val ageValuesList : Array<String> by lazy { resources.getStringArray(R.array.age_values) }
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        signUpViewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)
        setAutoTextViewAdapter()
        setFinishSignUpButtonListener()
    }

    private val finishSignUpListener = View.OnClickListener {
        val nameEntered : String = name.text.toString()
        val phoneEntered : String = phone.text.toString()
        val ageSelected : String = age.text.toString()
        signUpViewModel.writeToDatabase(nameEntered, phoneEntered, ageSelected)
        navController.navigate(R.id.action_detailsFragment_to_mainFragment)
    }

    private fun setFinishSignUpButtonListener() {
        finishSignUp.setOnClickListener(finishSignUpListener)
    }

    private fun setAutoTextViewAdapter() {
        val adapter = ArrayAdapter(requireContext(),
            R.layout.fragment_drop_down_view, ageValuesList)
        age.setAdapter(adapter)
    }
}