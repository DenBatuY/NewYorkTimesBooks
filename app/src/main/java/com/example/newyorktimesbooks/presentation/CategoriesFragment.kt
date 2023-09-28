package com.example.newyorktimesbooks.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newyorktimesbooks.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment:Fragment(R.layout.categories_fragment) {
    private val categoriesViewModel by viewModel<CategoriesViewModel> ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesViewModel.loadCategories()
    }
}