package com.bigbrother.data.datasource.project

import com.bigbrother.Result
import com.bigbrother.data.database.dao.ProjectDao
import com.bigbrother.data.database.dao.TagsDao
import com.bigbrother.data.database.dao.TaskDao
import com.bigbrother.data.datasource.project.model.ProjectDto
import com.bigbrother.data.datasource.project.model.TagDto
import com.bigbrother.data.datasource.project.model.TaskDto

class ProjectDataSource(
    private val tagsDao: TagsDao,
    private val tasksDao: TaskDao,
    private val projectDao: ProjectDao
) : IProjectDataSource {
    override fun getProject(projectId: String): Result<ProjectDto> {
        val value = projectDao.getProject(projectId)
        return if (value == null) Result.Failure()
        else Result.Success(value.map())
    }

    override fun getProjects(): Result<List<ProjectDto>> {
        val value = projectDao.getProjects()
        return if (value.isEmpty()) Result.Failure()
        else Result.Success(value.map { it.map() })
    }

    override fun getTasksByProject(projectId: String): Result<List<TaskDto>> {
        val value = tasksDao.getTasksFromProject(projectId)
        return if (value.isEmpty()) Result.Failure()
        else Result.Success(value.map { it.map() })
    }


    override fun addProject(project: ProjectDto) {
        projectDao.addProject(project.map())
    }

    override fun addTask(taskDto: TaskDto) {
        tasksDao.addTask(taskDto.map())
    }

    override fun addTag(tagDto: TagDto) {
        TODO("Not yet implemented")
    }

    override fun deleteProject(projectId: String) {
        projectDao.deleteProject(projectId)
    }

    override fun deleteTag(tagDto: TagDto) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(taskDto: TaskDto) {
        tasksDao.deleteTask(taskDto.map())
    }

    override fun updateProject(project: ProjectDto) {
        projectDao.updateProject(project.map())
    }

    override fun updateTask(taskDto: TaskDto) {
        tasksDao.updateTask(taskDto.map())
    }
}