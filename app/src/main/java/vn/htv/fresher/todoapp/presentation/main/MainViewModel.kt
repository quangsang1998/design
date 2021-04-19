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

  fun getTaskList() {
   disposables += getTaskListUseCase()
     .subscribeBy(
       onSuccess = {
         Timber.i("Task count: ${it.size}")
       },
       onError = {

       }
     )
  }

  fun insertDummyTask() {
    val model = TaskModel(
      name = "Dummy task name"
    )
    disposables += saveTaskUseCase(model)
      .subscribeBy(
        onComplete = {
          Timber.i("Saved [$model] to Room database successful.")
        },
        onError = {
          Timber.e("Has an error occurred when save [$model] to Room database.")
        }
      )
  }
}