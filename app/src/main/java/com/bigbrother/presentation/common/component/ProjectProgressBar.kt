package com.bigbrother.presentation.common.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.bigbrother.R
import com.bigbrother.databinding.ComponentProjectProgressbarBinding

class ProjectProgressBar(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {
    private val binding =
        ComponentProjectProgressbarBinding.inflate(LayoutInflater.from(context), this, true)
    private val progressWidth = resources.getDimensionPixelSize(R.dimen.project_progress_width)
    fun setProgress(p1: Float, p2: Float, p3: Float, p4: Float) {
        binding.apply {
            projectProgressTodo.layoutParams.width = (progressWidth * p1).toInt()
            projectProgressInProgress.layoutParams.width = (progressWidth * p2).toInt()
            projectProgressBlocked.layoutParams.width = (progressWidth * p3).toInt()
            projectProgressDone.layoutParams.width = (progressWidth * p4).toInt()
        }
    }
}