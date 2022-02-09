package com.bigbrother.presentation.common.component.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.bigbrother.databinding.ItemBoardColumnBinding
import com.bigbrother.presentation.base.BaseRecyclerViewAdapter
import com.bigbrother.presentation.base.BaseViewHolder
import com.bigbrother.presentation.common.component.DragAndDropComponent
import com.bigbrother.presentation.common.component.StartSnapHelper
import com.bigbrother.presentation.features.projectboard.model.BoardColumnVO

class BoardAdapter(
    items: List<BoardColumnVO>,
    private val dragAndDropComponent: DragAndDropComponent
) :
    BaseRecyclerViewAdapter<BoardColumnVO, BoardAdapter.ColumnViewHolder>(items) {

    private val columnAdapter: MutableList<BoardColumnAdapter> = mutableListOf()

    init {
        items.forEach {
            columnAdapter.add(BoardColumnAdapter(it.tasks, dragAndDropComponent))
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColumnViewHolder {
        val binding =
            ItemBoardColumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        with(binding.itemBoardColumn) {
            val snapHelper = StartSnapHelper()
            snapHelper.attachToRecyclerView(this)
            layoutManager = LinearLayoutManager(parent.context, VERTICAL, false)
        }
        return ColumnViewHolder(binding)
    }

    inner class ColumnViewHolder(private val binding: ItemBoardColumnBinding) :
        BaseViewHolder<BoardColumnVO>(binding) {
        override fun bind(item: BoardColumnVO) {
            binding.apply {
                itemBoardColumnName.text = "${item.name} ${item.tasks.size}"
                itemBoardColumn.adapter = columnAdapter[adapterPosition]
                root.setOnDragListener(dragAndDropComponent.addListener())
            }
        }

    }
}
