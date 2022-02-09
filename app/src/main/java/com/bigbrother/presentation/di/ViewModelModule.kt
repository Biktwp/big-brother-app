package com.bigbrother.presentation.di

import com.bigbrother.presentation.features.projectboard.viewmodel.ProjectBoardViewModel
import com.bigbrother.presentation.features.projects.viewmodel.ProjectsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProjectsViewModel() }
    viewModel { ProjectBoardViewModel() }
}