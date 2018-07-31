package com.example.nikitalevcenko.githubapp.base.ui

import android.view.View

fun View.setVisibility(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}