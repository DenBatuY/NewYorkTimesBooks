package com.example.newyorktimesbooks.presentation.adapters.categories_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.newyorktimesbooks.databinding.CategoriesItemBinding
import com.example.newyorktimesbooks.domain.CategoriesEntity

class CategoriesAdapter :
    ListAdapter<CategoriesEntity, CategoriesViewHolder>(CategoriesDiffUtilCallBack()) {

    var onClickCategory: ((encodedName:String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = CategoriesItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = getItem(position)
        holder.binding.root.setOnClickListener {
            onClickCategory?.invoke(categories.listNameEncoded)
        }
    }

}