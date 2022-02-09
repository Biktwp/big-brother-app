package com.bigbrother.presentation.features.projectboard.model

data class BoardColumnVO(
    val name: String,
    val tasks: List<TaskVO>
)
