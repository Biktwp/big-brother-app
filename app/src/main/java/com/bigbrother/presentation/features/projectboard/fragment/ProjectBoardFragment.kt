package com.bigbrother.presentation.features.projectboard.fragment

import android.view.LayoutInflater
import com.bigbrother.databinding.FragmentProjectBoardBinding
import com.bigbrother.presentation.base.BaseFragment
import com.bigbrother.presentation.features.projectboard.model.BoardColumnVO
import com.bigbrother.presentation.features.projectboard.model.TaskVO
import com.bigbrother.presentation.features.projectboard.viewmodel.ProjectBoardViewModel
import com.bigbrother.presentation.features.projects.model.ProjectVO
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectBoardFragment : BaseFragment<FragmentProjectBoardBinding>() {
    override val viewModel: ProjectBoardViewModel by viewModel()
    private lateinit var project: ProjectVO

    override fun inflate(inflater: LayoutInflater) = FragmentProjectBoardBinding.inflate(inflater)

    override fun getBundleArguments() {
        val args = ProjectBoardFragmentArgs.fromBundle(requireArguments())
        project = args.project
    }

    override fun addBindingVariables() {
        binding.apply {
            projectBoardTitle.text = project.name
            projectBoardList.setColumns(
                listOf(
                    BoardColumnVO(
                        "TODO",
                        listOf(
                            TaskVO("2", "2", "2", null),
                        )
                    ), BoardColumnVO(
                        "TODO",
                        listOf(
                        )
                    ), BoardColumnVO(
                        "TODO",
                        listOf(
                        )
                    )
                )
            )

        }
    }

}