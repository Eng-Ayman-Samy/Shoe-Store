package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel

class DetailFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val detailBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(layoutInflater)
        val viewModel: ShoeViewModel by activityViewModels()
        detailBinding.vm = viewModel

        detailBinding.cancelButton.setOnClickListener {
            it.findNavController().navigateUp()
            //it.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment(null))
        }
        detailBinding.saveButton.setOnClickListener {
            viewModel.addShoe()
            it.findNavController().navigateUp()
//            val shoe = Shoe(
//                name = detailBinding.shoeName.text.toString(),
//                size = if (detailBinding.shoeSize.text.toString()
//                        .isNotEmpty()
//                ) detailBinding.shoeSize.text.toString().toDouble() else 0.0,
//                company = detailBinding.company.text.toString(),
//                description = detailBinding.description.text.toString()
//            )
//            viewModel.addShoe(shoe)

            //it.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment(shoe))
        }

        // Inflate the layout for this fragment
        return detailBinding.root//inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}