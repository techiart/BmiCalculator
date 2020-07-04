package com.inspirecoding.bmicalculator.bmis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.inspirecoding.bmicalculator.MainActivity
import com.inspirecoding.bmicalculator.databinding.BmisFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BmisFragment : Fragment()
{
    private lateinit var binding: BmisFragmentBinding
    private val viewModel: BmisViewModel by viewModel()

    override fun onStart()
    {
        super.onStart()
        (activity as MainActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = BmisFragmentBinding.inflate(
            inflater, container, false
        )
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        onFabClick()
        setupListAdapter()
    }

    private fun setupListAdapter()
    {
        val viewmodel = binding.viewmodel
        if(viewmodel != null)
        {
            binding.recyclerView.adapter = BmisListAdapter(viewmodel)
        }
        else
        {
            Log.w("No init ViewModel", "ViewModel not initialized when attempting to set up adapter.")
        }
    }

    private fun onFabClick()
    {
        binding.fabCalculateNewBmi.setOnClickListener {
            val action = BmisFragmentDirections.actionBmisFragmentToAddNewBmiFragment()
            findNavController().navigate(action)
        }
    }
}