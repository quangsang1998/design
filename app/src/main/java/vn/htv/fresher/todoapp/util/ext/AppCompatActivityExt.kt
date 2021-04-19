package vn.htv.fresher.todoapp.util.ext

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import vn.htv.fresher.todoapp.R

fun AppCompatActivity.replaceFragment(
  fragment      : Fragment,
  @IdRes where  : Int     = R.id.content,
  tag           : String  = fragment::class.java.simpleName
) {
  supportFragmentManager.beginTransaction()
    .replace(where, fragment, tag)
    .commit()
}