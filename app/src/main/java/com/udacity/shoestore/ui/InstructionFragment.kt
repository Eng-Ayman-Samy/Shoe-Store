package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {
    private var _binding: InstructionFragmentBinding? = null
    private val instructionBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = InstructionFragmentBinding.inflate(layoutInflater)
        instructionBinding.startButton.setOnClickListener {
            it.findNavController()
                .navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }
        // Inflate the layout for this fragment
        return instructionBinding.root//inflater.inflate(R.layout.instruction_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}