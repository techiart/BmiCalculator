package com.inspirecoding.bmicalculator.addnewbmi

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.AddNewBmiFragmentBinding

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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        setupNavigation()
    }
    private fun setupNavigation()
    {
        binding.btnCalculateBmi.setOnClickListener {
            val action = AddNewBmiFragmentDirections.actionAddNewBmiFragmentToResultFragment()
            findNavController().navigate(action)
        }
    }
}