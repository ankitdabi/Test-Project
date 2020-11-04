package com.example.testapplication

import android.view.View

interface OnRecyclerViewItemClickListener {
    fun onRecyclerViewItemClicked(verticalPosition: Int, horizontalPosition: Int, view: View?)
}