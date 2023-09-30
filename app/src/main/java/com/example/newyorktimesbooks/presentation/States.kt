package com.example.newyorktimesbooks.presentation

import android.content.Context
import androidx.core.view.isVisible
import com.example.newyorktimesbooks.R
import com.example.newyorktimesbooks.databinding.BooksListFragmentBinding
import com.example.newyorktimesbooks.databinding.CategoriesFragmentBinding
import com.example.newyorktimesbooks.domain.entitys.StateEnum
import com.example.newyorktimesbooks.domain.entitys.StateEnum.*

fun categoryStates(binding: CategoriesFragmentBinding, state: StateEnum,context: Context) {
    when (state) {
        LOADING -> {
            binding.progressBarCategories.containerLoading.isVisible = true
            binding.tvErrorCategories.isVisible = false
        }

        ERROR -> {
            binding.progressBarCategories.containerLoading.isVisible = false
            binding.swipeRefreshCategories.isRefreshing = false
            binding.tvErrorCategories.isVisible = true
            binding.tvErrorCategories.text = getString(context,R.string.error_you_are_offline)
        }

        INTERNET_ERROR -> {
            binding.progressBarCategories.containerLoading.isVisible = false
            binding.swipeRefreshCategories.isRefreshing = false
            binding.tvErrorCategories.isVisible = true
            binding.tvErrorCategories.text = getString(context,R.string.internet_error_you_are_offline)
        }

        SUCCESS -> {
            binding.progressBarCategories.containerLoading.isVisible = false
            binding.swipeRefreshCategories.isRefreshing = false
            binding.tvErrorCategories.isVisible = false
        }
    }
}

fun booksListStates(binding: BooksListFragmentBinding, state: StateEnum,context: Context) {
    when (state) {
        LOADING -> {
            binding.progressBarBooksList.containerLoading.isVisible = true
            binding.tvErrorBooks.isVisible = false
        }

        ERROR -> {
            binding.progressBarBooksList.containerLoading.isVisible = false
            binding.swipeRefreshBooks.isRefreshing = false
            binding.tvErrorBooks.isVisible = true
            binding.tvErrorBooks.text = getString(context,R.string.error_you_are_offline)
        }

        INTERNET_ERROR -> {
            binding.progressBarBooksList.containerLoading.isVisible = false
            binding.swipeRefreshBooks.isRefreshing = false
            binding.tvErrorBooks.isVisible = true
            binding.tvErrorBooks.text = getString(context,R.string.internet_error_you_are_offline)
        }

        SUCCESS -> {
            binding.progressBarBooksList.containerLoading.isVisible = false
            binding.swipeRefreshBooks.isRefreshing = false
            binding.tvErrorBooks.isVisible = false
        }
    }
}


private fun getString(context: Context, idString: Int): String {
    return context.getString(idString)
}