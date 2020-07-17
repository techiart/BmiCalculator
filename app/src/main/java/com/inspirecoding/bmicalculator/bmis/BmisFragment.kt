package com.inspirecoding.bmicalculator.bmis

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.inspirecoding.bmicalculator.EventObserver
import com.inspirecoding.bmicalculator.MainActivity
import com.inspirecoding.bmicalculator.R
import com.inspirecoding.bmicalculator.databinding.BmisFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BmisFragment : Fragment()
{
    private lateinit var binding: BmisFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: BmisViewModel

    override fun onStart()
    {
        super.onStart()
        (activity as MainActivity).supportActionBar?.show()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(BmisViewModel::class.java)
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
        setupDeleteBmiDialog()
    }

    private fun setupDeleteBmiDialog()
    {
        viewModel.deleteBmiDialog.observe(viewLifecycleOwner, EventObserver { _bmi ->
            context?.let { _context ->
                val dialog = BottomSheetDialog(_context)
                dialog.setContentView(this.layoutInflater.inflate(R.layout.dialog_bottomsheet_deleteitem,null))
                dialog.findViewById<AppCompatButton>(R.id.btn_cancel)?.setOnClickListener {
                    dialog.dismiss()
                }
                dialog.findViewById<AppCompatButton>(R.id.btn_delete)?.setOnClickListener {
                    viewModel.deleteBmi((_bmi))
                    dialog.dismiss()
                }
                dialog.show()
            }
        })
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
            val action = BmisFragmentDirections
                .actionBmisFragmentToAddNewBmiFragment()
            findNavController().navigate(action)
        }
    }
}