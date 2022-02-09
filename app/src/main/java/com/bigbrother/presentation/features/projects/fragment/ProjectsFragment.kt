package com.bigbrother.presentation.features.projects.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigbrother.R
import com.bigbrother.databinding.FragmentProjectsBinding
import com.bigbrother.presentation.base.BaseFragment
import com.bigbrother.presentation.common.OnProjectClickListener
import com.bigbrother.presentation.features.projects.adapter.ProjectsAdapter
import com.bigbrother.presentation.features.projects.model.ProjectVO
import com.bigbrother.presentation.features.projects.viewmodel.ProjectsViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectsFragment : BaseFragment<FragmentProjectsBinding>() {

    override val viewModel: ProjectsViewModel by viewModel()
    override fun inflate(inflater: LayoutInflater) = FragmentProjectsBinding.inflate(inflater)
    private var onProjectClickListener: OnProjectClickListener? = null
    private val project = mutableListOf<ProjectVO>()
    override fun onAttach(context: Context) {
        onProjectClickListener = context as? OnProjectClickListener
        super.onAttach(context)
    }

    override fun addBindingVariables() {
        binding.apply {
            val adapter = ProjectsAdapter(onProjectClickListener)
            projectsList.adapter = adapter
            projectsList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter.submitList(project)

            projectNewProject.setOnClickListener {
            }


    }

}