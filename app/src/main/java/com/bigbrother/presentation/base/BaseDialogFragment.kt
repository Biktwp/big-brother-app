package com.bigbrother.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {

    protected val binding get() = _binding!!
    private var _binding: VB? = null
    protected abstract val viewModel: BaseViewModel
    abstract fun inflate(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(layoutInflater)
        getBundleArguments()
        observeViewModel()
        addBindingVariables()
        init()
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    open fun init() {}
    open fun observeViewModel() {}
    open fun getBundleArguments() {}
    open fun addBindingVariables() {}

}