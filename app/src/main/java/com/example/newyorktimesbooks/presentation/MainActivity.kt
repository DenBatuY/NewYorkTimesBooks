package com.example.newyorktimesbooks.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denbatuy.core.navigation.Navigator
import com.example.newyorktimesbooks.R
import com.example.newyorktimesbooks.presentation.fragments.BooksListFragment
import com.example.newyorktimesbooks.presentation.fragments.CategoriesFragment
import com.example.newyorktimesbooks.presentation.fragments.WebFragment

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstLoading(savedInstanceState)
    }

    private fun firstLoading(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, CategoriesFragment()).commit()
        }
    }

    override fun goToBookList(categoryApi: String, categoryTitle: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_fragment_container,
                BooksListFragment.newInstance(categoryApi, categoryTitle)
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val webFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
        if (webFragment is WebFragment && webFragment.onBackPressed()) {
            return
        } else
            super.onBackPressed()
    }

    override fun goToWebFragment(link: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_fragment_container,
                WebFragment.newInstance(link)
            )
            .addToBackStack(null)
            .commit()
    }
}