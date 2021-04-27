package vn.htv.fresher.todoapp.util

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import vn.htv.fresher.todoapp.util.ext.show

@BindingAdapter("bind:imageResource")
fun setImageResource(imageView: ImageView, @DrawableRes drawableId: Int? = null) {
  val id = drawableId ?: return
  imageView.setImageResource(id)
}

@BindingAdapter("bind:goneUnless")
fun goneUnless(view: View, isShown: Boolean) {
  view.show(isShown)
}