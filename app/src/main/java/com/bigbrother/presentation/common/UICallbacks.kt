package com.bigbrother.presentation.common

import com.bigbrother.presentation.features.projects.model.ProjectVO

interface OnProjectClickListener {
    fun onProjectClick(project: ProjectVO)
}