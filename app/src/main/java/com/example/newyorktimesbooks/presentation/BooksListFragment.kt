package com.example.newyorktimesbooks.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newyorktimesbooks.databinding.BooksListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksListFragment:Fragment() {

    private var _binding: BooksListFragmentBinding? = null
    private val binding: BooksListFragmentBinding
        get() = _binding ?: throw RuntimeException("BooksListFragmentBinding == null")
    private val categoriesViewModel by viewModel<CategoriesViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BooksListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
companion object{
    private const val CATEGORY_NAME = "category"
    fun newInstance( category: String) = BooksListFragment().apply {
        arguments = Bundle().apply {
            putString(CATEGORY_NAME, category)
        }
    }
}
}