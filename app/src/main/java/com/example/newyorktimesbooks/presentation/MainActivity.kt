package com.example.newyorktimesbooks.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denbatuy.core.navigation.Navigator
import com.example.newyorktimesbooks.R

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstLoading(savedInstanceState)
    }

    private fun firstLoading(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, CategoriesFragment()).commit()
        }
    }

    override fun goToBookList(category: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_container, BooksListFragment.newInstance(category))
            .addToBackStack(null)
            .commit()
    }
}