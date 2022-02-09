package com.bigbrother.presentation.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerViewAdapterAsync<T : Any, VH : BaseViewHolder<T>>(diff: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diff) {
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}