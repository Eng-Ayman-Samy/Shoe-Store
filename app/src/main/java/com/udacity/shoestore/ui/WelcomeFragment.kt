package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private var _binding: WelcomeFragmentBinding? = null
    private val welcomeBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = WelcomeFragmentBinding.inflate(layoutInflater)

        welcomeBinding.goButton.setOnClickListener {
            it.findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        // Inflate the layout for this fragment
        return welcomeBinding.root//inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}