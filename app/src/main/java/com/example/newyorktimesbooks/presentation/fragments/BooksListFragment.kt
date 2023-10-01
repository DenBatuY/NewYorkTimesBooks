package com.example.newyorktimesbooks.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denbatuy.core.navigation.navigator
import com.denbatuy.core.observeWithLifecycle
import com.example.newyorktimesbooks.databinding.BooksListFragmentBinding
import com.example.newyorktimesbooks.domain.entitys.StateEnum.ERROR
import com.example.newyorktimesbooks.domain.entitys.StateEnum.INTERNET_ERROR
import com.example.newyorktimesbooks.domain.entitys.StateEnum.LOADING
import com.example.newyorktimesbooks.domain.entitys.StateEnum.SUCCESS
import com.example.newyorktimesbooks.presentation.adapters.books_adapter.BooksAdapter
import com.example.newyorktimesbooks.presentation.booksListStates
import com.example.newyorktimesbooks.presentation.viewmodels.BooksListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksListFragment : Fragment() {

    private var _binding: BooksListFragmentBinding? = null
    private val binding: BooksListFragmentBinding
        get() = _binding ?: throw RuntimeException("BooksListFragmentBinding == null")
    private val booksViewModel by viewModel<BooksListViewModel>()
    private val booksAdapter by lazy { BooksAdapter() }
    private val categoryNameApi: String?
        get() = arguments?.getString(CATEGORY_NAME_FOR_API)

    private val categoryNameTitle: String?
        get() = arguments?.getString(CATEGORY_NAME_FOR_TITLE)

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
        initAdapter()
        loadBooks()
        observeState()
        openLink()
        swipeRefresh()
        observe()
    }

    private fun initAdapter() {
        binding.rvBook.adapter = booksAdapter
    }

    private fun loadBooks() {
        categoryNameApi?.let { booksViewModel.loadBookByCategories(it) }
    }

    private fun openLink() {
        booksAdapter.openLink = {
            navigator().goToWebFragment(it)
        }
    }

    private fun observeState() {
        binding.tvTitleBook.text = categoryNameTitle
        booksViewModel.getBooksState.observeWithLifecycle(viewLifecycleOwner) { response ->
            response.ifSuccess { booksListStates(binding, SUCCESS, requireContext()) }
            response.ifLoading { booksListStates(binding, LOADING, requireContext()) }
            response.ifError { booksListStates(binding, ERROR, requireContext()) }
            response.ifInternetError { booksListStates(binding, INTERNET_ERROR, requireContext()) }
        }
    }

    private fun observe() {
        categoryNameTitle?.let {
            booksViewModel.getBooks(it).observeWithLifecycle(viewLifecycleOwner) { listBooks ->
                booksAdapter.submitList(listBooks)
            }
        }
    }

    private fun swipeRefresh() {
        binding.swipeRefreshBooks.setOnRefreshListener {
            loadBooks()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val CATEGORY_NAME_FOR_API = "category_api"
        private const val CATEGORY_NAME_FOR_TITLE = "category_title"
        fun newInstance(categoryApi: String, categoryTitle: String) = BooksListFragment().apply {
            arguments = Bundle().apply {
                putString(CATEGORY_NAME_FOR_API, categoryApi)
                putString(CATEGORY_NAME_FOR_TITLE, categoryTitle)
            }
        }
    }
}