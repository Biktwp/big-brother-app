package com.bigbrother.domain.repository

import com.bigbrother.Result
import com.bigbrother.data.datasource.project.IProjectDataSource
import com.bigbrother.domain.mapper.map
import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.domain.model.TaskBo

class ProjectRepository(private val dataSource: IProjectDataSource) : IProjectRepository {
    override fun getProjects(): Result<List<ProjectBo>> =
        dataSource.getProjects().mapSuccess { it.map { it.map() } }

    override fun getProject(projectId: String): Result<ProjectBo> =
        dataSource.getProject(projectId).mapSuccess { it.map() }

    override fun getTasksByProject(projectId: String): Result<List<TaskBo>> =
        dataSource.getTasksByProject(projectId).mapSuccess { it.map { it.map() } }

    override fun addProject(projectBo: ProjectBo) {
        dataSource.addProject(projectBo.map())
    }

    override fun addTask(taskBo: TaskBo) {
        dataSource.addTask(taskBo.map())
    }

    override fun deleteProject(projectId: String) {
        dataSource.deleteProject(projectId)
    }

    override fun deleteTask(taskBo: TaskBo) {
        dataSource.deleteTask(taskBo.map())
    }
}