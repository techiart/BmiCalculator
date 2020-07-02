package com.inspirecoding.bmicalculator.bmis

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.inspirecoding.bmicalculator.EventObserver
import com.inspirecoding.bmicalculator.MainActivity
import com.inspirecoding.bmicalculator.databinding.BmisFragmentBinding

class BmisFragment : Fragment()
{
    private lateinit var binding: BmisFragmentBinding
    private val viewModel by viewModels<BmisViewModel>()

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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        onFabClick()

        viewModel.items.observe(viewLifecycleOwner, Observer { _listOfBmis ->
            Log.d("list of BMIs", "$_listOfBmis")
        })
    }

    private fun onFabClick()
    {
        binding.fabCalculateNewBmi.setOnClickListener {
            val action = BmisFragmentDirections
                .actionBmisFragmentToAddNewBmiFragment()
            findNavController().navigate(action)
        }
    }
}