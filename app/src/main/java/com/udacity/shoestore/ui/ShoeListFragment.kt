package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.ShoeViewModel
import com.udacity.shoestore.models.asString
import com.udacity.shoestore.models.toStringAsList
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private var _binding: ShoeListFragmentBinding? = null
    private val shoeListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: ShoeViewModel by activityViewModels()
        _binding = ShoeListFragmentBinding.inflate(layoutInflater)
        //val arg = ShoeListFragmentArgs.fromBundle(requireArguments())
        Timber.tag("Tag").v(viewModel.shoeList.value?.toStringAsList())

        viewModel.shoeList.observe(viewLifecycleOwner) {
            it.let {
                it.forEach { shoe ->
                    val tView = TextView(this.context)
                    tView.layoutParams = shoeListBinding.linearLayout.layoutParams
                    tView.text = shoe.asString()
                    tView.textSize = 20f
                    shoeListBinding.linearLayout.addView(tView)
//                    val hDivider = View(this.context)
//                    hDivider.layoutParams = tView.layoutParams
//                    hDivider.layoutParams.height = 1
//                    hDivider.setBackgroundColor(Color.BLACK)
//                    shoeListBinding.linearLayout.addView(hDivider)
                }
                //shoeListBinding.shoeList.text = it.toStringAsList()
            }
        }

        shoeListBinding.addShoeButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        //setHasOptionsMenu deprecated
        //reference https://stackoverflow.com/questions/71917856/sethasoptionsmenuboolean-unit-is-deprecated-deprecated-in-java

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.logout) {
                    findNavController().navigate(R.id.action_shoeListFragment_to_login_fragment)
                }
                //without NavigationUI.onNavDestinationSelected
                //navigation back button will not function
                return NavigationUI.onNavDestinationSelected(
                    menuItem, findNavController()
                )
                // return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        // Inflate the layout for this fragment
        return shoeListBinding.root//inflater.inflate(R.layout.shoe_list_fragment, container, false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}