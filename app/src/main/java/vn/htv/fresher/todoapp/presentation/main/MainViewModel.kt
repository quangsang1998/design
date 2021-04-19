package vn.htv.fresher.todoapp.presentation.main

import io.reactivex.rxkotlin.subscribeBy
import vn.htv.fresher.todoapp.domain.usecase.task.SaveTaskUseCase
import vn.htv.fresher.todoapp.presentation.common.BaseViewModel
import timber.log.Timber
import io.reactivex.rxkotlin.plusAssign
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskListUseCase

class MainViewModel(
  private val getTaskListUseCase  : GetTaskListUseCase,
  private val saveTaskUseCase     : SaveTaskUseCase
) : BaseViewModel() {

}