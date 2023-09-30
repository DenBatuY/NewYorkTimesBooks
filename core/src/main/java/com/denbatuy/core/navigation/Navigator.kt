package com.denbatuy.core.navigation

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {
    fun goToBookList(categoryApi: String, categoryTitle: String)
    fun goToWebFragment(link: String)
}
