package com.example.newyorktimesbooks.presentation.adapters.books_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.newyorktimesbooks.R
import com.example.newyorktimesbooks.databinding.BooksItemBinding
import com.example.newyorktimesbooks.domain.entitys.BooksEntity

class BooksAdapter : ListAdapter<BooksEntity, BooksViewHolder>(BooksDiffUtilCallBack()) {

    var openLink: ((link: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = BooksItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book = getItem(position)
        with(holder.binding) {
            holder.linkAdapter.setLinks(book.buy_links)
            Glide.with(root).load(book.book_image).error(R.drawable.book).into(ivBook)
            tvDescription.text = book.description
            tvBookTitle.text = book.title
            tvRank.text = String.format("%s%s", RANK, book.rank)
            tvAuthor.text = String.format("%s%s", AUTHOR, book.author)
            tvPublisher.text = String.format("%s%s", PUBLISHER, book.publisher)
            holder.linkAdapter.onClickLink = {
                openLink?.invoke(it)
            }
        }
    }

    companion object {
        private const val RANK = "Rank: "
        private const val AUTHOR = "Author: "
        private const val PUBLISHER = "Publisher: "
    }
}