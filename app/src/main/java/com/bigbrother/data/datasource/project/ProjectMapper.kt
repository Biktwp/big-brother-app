package com.bigbrother.data.datasource.project

import com.bigbrother.data.database.model.ProjectEntity
import com.bigbrother.data.database.model.TaskEntity
import com.bigbrother.data.datasource.project.model.ProjectDto
import com.bigbrother.data.datasource.project.model.TaskDto

fun ProjectEntity.map(): ProjectDto = ProjectDto(id = id, title = name, columns = columns)

fun ProjectDto.map(): ProjectEntity = ProjectEntity(
    id = id,
    name = title,
    creationDate = System.currentTimeMillis(),
    columns = columns
)

fun TaskDto.map(): TaskEntity = TaskEntity(
    id = id,
    projectId = projectId,
    title = title,
    description = description,
    column = column,
    creationDate = System.currentTimeMillis(),
    endDate = null,
    tags = tags
)

fun TaskEntity.map(): TaskDto = TaskDto(
    id = id,
    title = title,
    description = description,
    projectId = projectId,
    column = column,
    tags = tags
)