package com.bigbrother.presentation.features.projects.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bigbrother.databinding.ItemProjectBinding
import com.bigbrother.presentation.base.BaseRecyclerViewAdapterAsync
import com.bigbrother.presentation.base.BaseViewHolder
import com.bigbrother.presentation.common.OnProjectClickListener
import com.bigbrother.presentation.features.projects.model.ProjectVO

class ProjectsAdapter(
    private val onProjectClickListener: OnProjectClickListener?
) :
    BaseRecyclerViewAdapterAsync<ProjectVO, ProjectsAdapter.ProjectViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val itemBinding =
            ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewHolder(itemBinding)
    }

    inner class ProjectViewHolder(private val binding: ItemProjectBinding) :
        BaseViewHolder<ProjectVO>(binding) {
        override fun bind(item: ProjectVO) {
            binding.apply {
                root.setOnClickListener {
                    onProjectClickListener?.onProjectClick(item)
                }
                itemProjectName.text = item.name
                itemProjectProgress.setProgress(0.25F, 0.25F, 0.25F, 0.25F)
            }
        }

    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<ProjectVO>() {
            override fun areItemsTheSame(oldItem: ProjectVO, newItem: ProjectVO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProjectVO, newItem: ProjectVO): Boolean {
                return oldItem == newItem
            }

        }
    }

}