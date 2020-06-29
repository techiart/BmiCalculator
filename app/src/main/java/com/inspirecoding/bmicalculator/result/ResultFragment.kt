package com.inspirecoding.bmicalculator.result

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.ResultFragmentBinding

class ResultFragment : Fragment()
{
    private lateinit var binding: ResultFragmentBinding
    private val viewModel by viewModels<ResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = ResultFragmentBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        setupRecalculationButton()
        setNavigateToBmisFragment()
    }

    private fun setupRecalculationButton()
    {
        binding.btnRecalculate.setOnClickListener {
            val action = ResultFragmentDirections
                .actionResultFragmentToAddNewBmiFragment()
            findNavController().navigate(action)
        }
    }
    private fun setNavigateToBmisFragment()
    {
        binding.btnSaveBmi.setOnClickListener {
            val action = ResultFragmentDirections
                .actionResultFragmentToBmisFragment()
            findNavController().navigate(action)
        }
    }
}