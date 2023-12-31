package com.example.newyorktimesbooks.presentation.adapters.books_adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.newyorktimesbooks.databinding.BooksItemBinding
import com.example.newyorktimesbooks.presentation.adapters.buy_links_adapter.BuyLinksAdapter

class BooksViewHolder(val binding: BooksItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val linkAdapter = BuyLinksAdapter()

    init {
        binding.rvBuyLinks.layoutManager =
            StaggeredGridLayoutManager( SPAN_COUNT,
                LinearLayoutManager.HORIZONTAL)
        binding.rvBuyLinks.adapter = linkAdapter
    }

    companion object{
        private const val SPAN_COUNT = 2
    }
}