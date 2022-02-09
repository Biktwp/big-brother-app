package com.bigbrother.presentation.common.component

import android.view.DragEvent
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bigbrother.R
import com.bigbrother.presentation.common.component.board.BoardColumnAdapter
import com.bigbrother.presentation.common.component.board.BoardComponent
import com.bigbrother.presentation.common.notNull
import com.bigbrother.presentation.features.projectboard.model.TaskVO
import com.google.android.material.card.MaterialCardView

class DragAndDropComponent(private val listener: BoardComponent.OnColumnDragListener) {

    var recyclerViewStart: RecyclerView? = null


    fun addListener(): View.OnDragListener {
        val listener = View.OnDragListener { p0, p1 ->
            when (p1?.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    if (recyclerViewStart == null) {
                        (p0 as? MaterialCardView)?.notNull {
                            recyclerViewStart = it.parent as? RecyclerView
                        }
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    if(p0 is LinearLayout) listener.onDragToColumn(p0)
                }
                DragEvent.ACTION_DROP -> {
                    if (p0 is LinearLayout) {
                        val recyclerView = p0.findViewById<RecyclerView>(R.id.item_board_column)
                        if (recyclerView != recyclerViewStart)
                            (recyclerView.adapter as? BoardColumnAdapter)?.notNull {
                                it.addTask(p1.localState as TaskVO)
                            }
                        (recyclerViewStart?.adapter as? BoardColumnAdapter)?.notNull {
                            it.removeTask(p1.localState as TaskVO)
                        }
                        recyclerViewStart = null
                    }
                }
                else -> {}
            }
            return@OnDragListener true
        }
        return listener
    }

}