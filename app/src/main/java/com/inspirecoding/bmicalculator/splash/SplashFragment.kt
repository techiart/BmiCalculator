package com.inspirecoding.bmicalculator.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.FragmentSplashBinding

class SplashFragment : Fragment()
{
    lateinit var binding: FragmentSplashBinding

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
}