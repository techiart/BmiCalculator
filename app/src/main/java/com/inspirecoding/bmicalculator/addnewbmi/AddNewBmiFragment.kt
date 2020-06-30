package com.inspirecoding.bmicalculator.addnewbmi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.inspirecoding.bmicalculator.EventObserver
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.AddNewBmiFragmentBinding
import com.inspirecoding.bmicalculator.utils.setupSnackbar

class AddNewBmiFragment : Fragment()
{
    private lateinit var binding: AddNewBmiFragmentBinding
    private val viewModel by viewModels<AddNewBmiViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = AddNewBmiFragmentBinding.inflate(
            layoutInflater, container, false
        )
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        setupSnackbar()
        setupNavigation()
    }

    private fun setupSnackbar()
    {
        view?.setupSnackbar(this, viewModel.snackbarText, Snackbar.LENGTH_SHORT)
    }
    private fun setupNavigation()
    {
        /** User EventObserver to do not run again the navigation **/
        viewModel.calculateBmiEvent.observe(viewLifecycleOwner, EventObserver {
            val action = AddNewBmiFragmentDirections.actionAddNewBmiFragmentToResultFragment(viewModel.bmi)
            findNavController().navigate(action)
        })
    }
}