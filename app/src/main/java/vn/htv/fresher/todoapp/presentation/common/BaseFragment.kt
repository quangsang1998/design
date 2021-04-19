package vn.htv.fresher.todoapp.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

  @get:LayoutRes
  protected abstract val layoutId: Int

  protected val safeContext by lazy {
    requireContext()
  }

  protected val safeActivity by lazy {
    requireActivity() as AppCompatActivity
  }

  protected lateinit var binding: DB

  // Open method, these method will be implement on child class
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  open fun init() {
    // Init Data element on child fragment
  }

  open fun initUi() {
    // Init UI element on child fragment
  }

  open fun registerListeners() {
    // Register event click listener on child fragment
  }

  open fun registerLiveDataListener() {

  }

  // Fragment overridden methods
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    binding.lifecycleOwner = this
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    init()
    initUi()
    registerListeners()
    registerLiveDataListener()
  }
}