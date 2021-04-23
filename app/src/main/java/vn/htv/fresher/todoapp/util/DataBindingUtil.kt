package vn.htv.fresher.todoapp.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:imageResource")
fun setImageResource(imageView: ImageView,  @DrawableRes drawableId: Int? = null) {
  val id = drawableId ?: return
  imageView.setImageResource(id)
}