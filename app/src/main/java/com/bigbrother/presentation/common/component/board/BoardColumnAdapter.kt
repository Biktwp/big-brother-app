package com.bigbrother.presentation.common.component.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import com.bigbrother.databinding.ItemTaskBinding
import com.bigbrother.presentation.base.BaseRecyclerViewAdapterAsync
import com.bigbrother.presentation.base.BaseViewHolder
import com.bigbrother.presentation.common.component.DragAndDropComponent
import com.bigbrother.presentation.features.projectboard.model.TaskVO

class BoardColumnAdapter(
    items: List<TaskVO>,
    private val dragAndDropComponent: DragAndDropComponent
) :
    BaseRecyclerViewAdapterAsync<TaskVO, BoardColumnAdapter.TaskViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    private val tasks: MutableList<TaskVO> = items.toMutableList()

    init {
        submitList(items)
    }


    fun removeTask(taskVO: TaskVO) {
        val index = tasks.indexOf(taskVO)
        if (index == -1) return
        tasks.removeAt(index)
        submitList(tasks)
        notifyDataSetChanged()
    }

    fun addTask(taskVO: TaskVO) {
        val index = tasks.indexOf(taskVO)
        if (index != -1) return
        tasks.add(taskVO)
        submitList(tasks)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        BaseViewHolder<TaskVO>(binding) {
        override fun bind(item: TaskVO) {
            binding.apply {
                taskTitle.text = item.title
                taskDescription.text = item.description
                taskId.text = item.id
                if (item.listener == null) {
                    item.listener = dragAndDropComponent.addListener()
                }
                root.setOnDragListener(item.listener)
                root.setOnLongClickListener {
                    ViewCompat.startDragAndDrop(it, null, View.DragShadowBuilder(it), item, 0)
                    return@setOnLongClickListener true
                }
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<TaskVO>() {
            override fun areItemsTheSame(oldItem: TaskVO, newItem: TaskVO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TaskVO, newItem: TaskVO): Boolean {
                return oldItem == newItem
            }

        }
    }
}
