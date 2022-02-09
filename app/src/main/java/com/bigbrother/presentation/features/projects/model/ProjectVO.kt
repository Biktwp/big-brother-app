package com.bigbrother.presentation.features.projects.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectVO(
    val id: String,
    val title: String,
    val columns: List<String>
) : Parcelable
