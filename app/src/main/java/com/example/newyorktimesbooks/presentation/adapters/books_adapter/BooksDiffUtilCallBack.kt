package com.example.newyorktimesbooks.presentation.adapters.books_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newyorktimesbooks.domain.entitys.BooksEntity

class BooksDiffUtilCallBack : DiffUtil.ItemCallback<BooksEntity>() {
    override fun areItemsTheSame(oldItem: BooksEntity, newItem: BooksEntity): Boolean {
        return oldItem.categoryName == newItem.categoryName
    }

    override fun areContentsTheSame(oldItem: BooksEntity, newItem: BooksEntity): Boolean {
        return oldItem == newItem
    }
}