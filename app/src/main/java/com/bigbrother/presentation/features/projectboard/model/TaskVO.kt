package com.bigbrother.presentation.features.projectboard.model

import android.view.View

data class TaskVO(
    val title: String,
    val description: String?,
    val id: String,
    var listener: View.OnDragListener?
)