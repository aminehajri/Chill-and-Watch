package com.hajri.chillandwatch

import android.view.View
import androidx.appcompat.widget.SearchView

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

/**
 * Fire event When [SearchView] query text has changed
 * @param action the function to execute when onQueryTextChange
 */
fun SearchView.eventWhenTextChanged(action: (query: String?) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(p0: String?): Boolean {
            p0?.let { action(it) }
            return false
        }
    })
}

/**
 * Fire event When [SearchView] has closed
 * @param action the function to execute when setOnCloseListener
 */
fun SearchView.eventOnCloseListener(action: () -> Unit) {
    setOnCloseListener {
        action()
        return@setOnCloseListener false
    }
}

