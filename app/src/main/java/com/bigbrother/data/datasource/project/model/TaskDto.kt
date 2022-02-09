package com.bigbrother.data.datasource.project.model

data class TaskDto(
    val id: String,
    val title: String,
    val description: String,
    val projectId: String,
    val column: String,
    val tags: List<String>
)