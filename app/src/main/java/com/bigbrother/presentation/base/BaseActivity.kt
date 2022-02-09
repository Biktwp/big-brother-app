package com.bigbrother.presentation.base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity(){

    protected val binding get() = _binding!!
    private var _binding: VB? = null
    abstract fun inflate(inflater: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        init()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


    abstract fun init()
    open fun addBindingVariables() {}


    private fun initDataBinding(){
        _binding = inflate(layoutInflater)
        setContentView(binding.root)
        addBindingVariables()
    }

}