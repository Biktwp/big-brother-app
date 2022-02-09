package com.bigbrother.presentation.features.projects.fragment

import android.view.LayoutInflater
import com.bigbrother.databinding.FragmentNewProjectBinding
import com.bigbrother.presentation.base.BaseDialogFragment
import com.bigbrother.presentation.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewProjectDialogFragment : BaseDialogFragment<FragmentNewProjectBinding>() {
    override val viewModel: BaseViewModel by viewModel()

    override fun inflate(inflater: LayoutInflater): FragmentNewProjectBinding =
        FragmentNewProjectBinding.inflate(inflater)

}