package com.example.newyorktimesbooks.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denbatuy.core.navigation.navigator
import com.denbatuy.core.observeWithLifecycle
import com.example.newyorktimesbooks.databinding.CategoriesFragmentBinding
import com.example.newyorktimesbooks.presentation.viewmodels.CategoriesViewModel
import com.example.newyorktimesbooks.presentation.adapters.categories_adapter.CategoriesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : Fragment() {
    private var _binding: CategoriesFragmentBinding? = null
    private val binding: CategoriesFragmentBinding
        get() = _binding ?: throw RuntimeException("CategoriesFragmentBinding == null")
    private val categoriesViewModel by viewModel<CategoriesViewModel>()
    private val categoriesAdapter by lazy { CategoriesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CategoriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        loadCategories()
        observe()
        openCategories()
    }

    private fun observe() {
        categoriesViewModel.category.observeWithLifecycle(viewLifecycleOwner) { response ->
            response.ifSuccess { categoriesAdapter.submitList(it) }
            response.ifLoading { }
            response.ifInternetError { }
            response.ifError { }
        }
    }

    private fun initAdapter() {
        binding.rvCategories.adapter = categoriesAdapter
    }

    private fun loadCategories() {
        categoriesViewModel.loadCategories()
    }

    private fun openCategories() {
        categoriesAdapter.onClickCategory = {
            navigator().goToBookList(it.listNameEncoded, it.listName)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}