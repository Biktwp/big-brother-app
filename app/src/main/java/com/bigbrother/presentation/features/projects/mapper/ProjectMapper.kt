package com.bigbrother.presentation.features.projects.mapper

import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.presentation.features.projects.model.ProjectVO


fun ProjectBo.mapToVO(): ProjectVO = ProjectVO(id, title, columns)

fun ProjectVO.mapToBo(): ProjectBo = ProjectBo(id, title, columns)