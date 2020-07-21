package com.inspirecoding.bmicalculator.result

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.inspirecoding.bmicalculator.EventObserver
import com.inspirecoding.bmicalculator.databinding.ResultFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment()
{
    private lateinit var binding: ResultFragmentBinding
    private val safeArgs: ResultFragmentArgs by navArgs()
    private val viewModel by viewModels<ResultViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = ResultFragmentBinding.inflate(
            inflater, container, false
        )
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        Log.d("ResultFragment", "${safeArgs.bmi}")
        viewModel.getBmi(safeArgs.bmi)

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
        viewModel.bmiSaveEvent.observe(viewLifecycleOwner, EventObserver {
            val action = ResultFragmentDirections
                .actionResultFragmentToBmisFragment()
            findNavController().navigate(action)
        })
    }
}