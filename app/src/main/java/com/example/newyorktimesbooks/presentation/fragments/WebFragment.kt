package com.example.newyorktimesbooks.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.newyorktimesbooks.databinding.WebViewFragmentBinding

class WebFragment : Fragment() {
    private var _binding: WebViewFragmentBinding? = null
    private val binding: WebViewFragmentBinding
        get() = _binding ?: throw RuntimeException("WebViewFragmentBinding == null")
    private lateinit var webView: WebView

    private val link: String?
        get() = arguments?.getString(LINK)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WebViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView(){
        webView = binding.webContainer
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        link?.let { binding.webContainer.loadUrl(it) }
    }

    fun onBackPressed(): Boolean {
        if (webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return false
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val LINK = "link"
        fun newInstance(link: String) = WebFragment().apply {
            arguments = Bundle().apply {
                putString(LINK, link)
            }
        }
    }
}