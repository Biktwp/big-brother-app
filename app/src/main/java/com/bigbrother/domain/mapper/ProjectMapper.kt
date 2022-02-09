package com.bigbrother.domain.mapper

import com.bigbrother.data.datasource.project.model.ProjectDto
import com.bigbrother.data.datasource.project.model.TaskDto
import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.domain.model.TaskBo

fun ProjectDto.map(): ProjectBo = ProjectBo(
    id = id, title = title, columns = columns
)

fun ProjectBo.map(): ProjectDto = ProjectDto(
    id = id, title = title, columns = columns
)

fun TaskDto.map(): TaskBo = TaskBo(
    id = id,
    title = title,
    description = description,
    projectId = projectId,
    column = column,
    tags = tags
)

fun TaskBo.map(): TaskDto = TaskDto(
    id = id,
    title = title,
    description = description,
    projectId = projectId,
    column = column,
    tags = tags
)