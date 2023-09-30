package com.denbatuy.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun <T> Flow<T>.observeWithLifecycle(owner: LifecycleOwner, lambda: (T) -> Unit) {
    val flow = this
    val scope = owner.lifecycleScope
    scope.launch() {
        owner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.onEach {
                lambda.invoke(it)
            }.launchIn(scope)
        }
    }
}