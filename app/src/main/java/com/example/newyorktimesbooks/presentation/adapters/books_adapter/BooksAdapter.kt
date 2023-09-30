package com.example.newyorktimesbooks.presentation.adapters.books_adapter

import android.content.Context
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
            tvRank.text = String.format("%s%s", getString(root.context, R.string.rank), book.rank)
            tvAuthor.text =
                String.format("%s%s", getString(root.context, R.string.author), book.author)
            tvPublisher.text =
                String.format("%s%s", getString(root.context, R.string.publisher), book.publisher)
            holder.linkAdapter.onClickLink = {
                openLink?.invoke(it)
            }
        }
    }

    private fun getString(context: Context, idString: Int): String {
        return context.getString(idString)
    }
}