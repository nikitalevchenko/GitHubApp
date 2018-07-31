package com.example.nikitalevcenko.githubapp.base.ui

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager

class KeyboardUtil(private val activity: Activity) {
    val keyboardOpened get() = mKeyboardOpened

    private var mKeyboardOpened = false

    private var mAppHeight: Int = 0
    private var mCurrentOrientation = -1

    private lateinit var mOnGlobalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
    private lateinit var mContentView: View

    fun hideKeyboard() {
        val currentFocus = activity.currentFocus

        currentFocus?.let {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        }
    }

    fun showKeyboard(view: View) {
        val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        inputMethodManager.showSoftInput(view, 0)
    }

    fun setKeyboardVisibilityListener(onKeyboardVisibilityChanged: (keyboardVisible: Boolean) -> Unit) {

        mContentView = activity.findViewById<View>(android.R.id.content)

        mOnGlobalLayoutListener = object : ViewTreeObserver.OnGlobalLayoutListener {
            private var mPreviousHeight: Int = 0

            override fun onGlobalLayout() {
                val newHeight = mContentView.height

                if (newHeight == mPreviousHeight)
                    return

                mPreviousHeight = newHeight

                if (activity.resources.configuration.orientation != mCurrentOrientation) {
                    mCurrentOrientation = activity.resources.configuration.orientation
                    mAppHeight = 0
                }

                if (newHeight >= mAppHeight) {
                    mAppHeight = newHeight
                }

                if (newHeight != 0) {
                    if (mAppHeight > newHeight) {
                        mKeyboardOpened = true
                        onKeyboardVisibilityChanged(true)
                    } else {
                        mKeyboardOpened = false
                        onKeyboardVisibilityChanged(false)
                    }
                }
            }
        }


        mContentView.viewTreeObserver.addOnGlobalLayoutListener(mOnGlobalLayoutListener)
    }

    fun removeKeyboardVisibilityListener() {
        mContentView.viewTreeObserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener)
    }
}