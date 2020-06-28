package com.inspirecoding.bmicalculator.result

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
}