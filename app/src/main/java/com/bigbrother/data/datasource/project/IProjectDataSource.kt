package com.bigbrother.data.datasource.project

import com.bigbrother.Result
import com.bigbrother.data.datasource.project.model.ProjectDto
import com.bigbrother.data.datasource.project.model.TagDto
import com.bigbrother.data.datasource.project.model.TaskDto

interface IProjectDataSource {
    fun getProjects(): Result<List<ProjectDto>>
    fun getProject(projectId: String): Result<ProjectDto>
    fun getTasksByProject(projectId: String): Result<List<TaskDto>>

    fun addProject(project: ProjectDto)
    fun addTask(taskDto: TaskDto)
    fun addTag(tagDto: TagDto)

    fun deleteProject(projectId: String)
    fun deleteTag(tagDto: TagDto)
    fun deleteTask(taskDto: TaskDto)

    fun updateProject(project: ProjectDto)
    fun updateTask(taskDto: TaskDto)

}