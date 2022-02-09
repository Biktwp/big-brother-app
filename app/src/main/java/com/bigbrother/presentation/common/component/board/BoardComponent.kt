package com.bigbrother.presentation.common.component.board

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bigbrother.presentation.common.component.DragAndDropComponent
import com.bigbrother.presentation.features.projectboard.model.BoardColumnVO


class BoardComponent @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    RecyclerView(context, attr) {

    init {
        layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        clipToPadding = false
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(this)
    }

    private var position = 0
    private val dragAndDropComponent = DragAndDropComponent(object : OnColumnDragListener {
        override fun onDragToColumn(x: View) {
            for (i in 0..this@BoardComponent.size)
                if (i != position && this@BoardComponent.getChildAt(i) == x) {
                    this@BoardComponent.smoothScrollToPosition(i)
                    position = i
                    return
                }
        }

    })

    fun setColumns(columns: List<BoardColumnVO>) {
        adapter = BoardAdapter(columns, dragAndDropComponent)
    }

    interface OnColumnDragListener {
        fun onDragToColumn(x: View)
    }

}