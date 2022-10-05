package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val loginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(layoutInflater)

        loginBinding.signUpButton.setOnClickListener {
            it.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            //findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
        loginBinding.loginButton.setOnClickListener {
            it.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return loginBinding.root//inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}