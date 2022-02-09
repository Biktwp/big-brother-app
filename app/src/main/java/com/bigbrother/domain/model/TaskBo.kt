package com.bigbrother.domain.model

data class TaskBo(
    val id: String,
    val title: String,
    val description: String,
    val projectId: String,
    val column: String,
    val tags: List<String>
)
