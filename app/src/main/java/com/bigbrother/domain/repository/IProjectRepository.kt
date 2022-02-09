package com.bigbrother.domain.repository

import com.bigbrother.Result
import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.domain.model.TaskBo

interface IProjectRepository {

    fun getProjects(): Result<List<ProjectBo>>
    fun getProject(projectId: String): Result<ProjectBo>
    fun getTasksByProject(projectId: String): Result<List<TaskBo>>

    fun addProject(projectBo: ProjectBo)
    fun addTask(taskBo: TaskBo)

    fun deleteProject(projectId: String)
    fun deleteTask(taskBo: TaskBo)

}