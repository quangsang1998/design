package vn.htv.fresher.todoapp.util.ext

import android.view.View

fun View.show(isShown: Boolean = true) {
  visibility = if (isShown) View.VISIBLE else View.GONE
}