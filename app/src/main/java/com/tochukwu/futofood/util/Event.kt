package com.tochukwu.futofood.util


import androidx.lifecycle.Observer

class Event <out T> (private val content: T){

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */

    fun getContentIfNotHandled(): T? {
        return if (!hasBeenHandled) {
            hasBeenHandled = true
            content
        } else null

    }

    /**
     * Returns the content, even if its already been handled
     */
    fun peekContent(): T = content
}