package com.inspirecoding.bmicalculator.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.inspirecoding.bmicalculator.MainActivity
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment()
{
    lateinit var binding: FragmentSplashBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onStart()
    {
        super.onStart()
        (activity as MainActivity).supportActionBar?.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        binding = FragmentSplashBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        coroutineScope.launch {
            delay(2_000)

            findNavController().navigate(R.id.action_splashFragment_to_bmisFragment)
        }
    }
}