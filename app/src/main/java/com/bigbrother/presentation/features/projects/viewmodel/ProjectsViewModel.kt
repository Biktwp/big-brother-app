package com.bigbrother.presentation.features.projects.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bigbrother.Result
import com.bigbrother.domain.usecase.AddProjectUseCase
import com.bigbrother.domain.usecase.DeleteProjectUseCase
import com.bigbrother.domain.usecase.GetProjectsUseCase
import com.bigbrother.presentation.base.BaseViewModel
import com.bigbrother.presentation.features.projects.mapper.mapToVO
import com.bigbrother.presentation.features.projects.model.ProjectVO

class ProjectsViewModel(
    private val deleteProjectUseCase: DeleteProjectUseCase,
    private val getProjectsUseCase: GetProjectsUseCase,
    private val addProjectUseCase: AddProjectUseCase
) : BaseViewModel() {

    private val _projects: MutableLiveData<List<ProjectVO>> by lazy { MutableLiveData<List<ProjectVO>>() }
    val projects: LiveData<List<ProjectVO>> = _projects

    fun getProjects() {
        getProjectsUseCase.invoke(params = Unit) {
            when (it) {
                is Result.Failure -> {}
                is Result.Success -> _projects.value = it.value.map { it.mapToVO() }
            }
        }
    }

    fun addProject(projectId: String, title: String, columns: List<String>) {
        addProjectUseCase.invoke(params = AddProjectUseCase.Params(title, projectId, columns)) {
            getProjects()
        }
    }

    fun deleteProject(projectId: String) {
        deleteProjectUseCase.invoke(params = DeleteProjectUseCase.Params(projectId)) {
            getProjects()
        }
    }

}