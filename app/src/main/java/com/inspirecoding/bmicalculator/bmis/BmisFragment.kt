package com.inspirecoding.bmicalculator.bmis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.inspirecoding.bmicalculator.databinding.BmisFragmentBinding

class BmisFragment : Fragment()
{
    private lateinit var binding: BmisFragmentBinding
    private val viewModel by viewModels<BmisViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = BmisFragmentBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }
}