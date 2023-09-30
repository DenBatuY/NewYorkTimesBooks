package com.example.newyorktimesbooks.presentation.adapters.categories_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newyorktimesbooks.domain.entitys.CategoriesEntity

class CategoriesDiffUtilCallBack : DiffUtil.ItemCallback<CategoriesEntity>() {
    override fun areItemsTheSame(oldItem: CategoriesEntity, newItem: CategoriesEntity): Boolean {
        return oldItem.listName == newItem.listName
    }

    override fun areContentsTheSame(oldItem: CategoriesEntity, newItem: CategoriesEntity): Boolean {
        return oldItem == newItem
    }
}