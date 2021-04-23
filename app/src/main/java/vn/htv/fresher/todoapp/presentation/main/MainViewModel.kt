package vn.htv.fresher.todoapp.presentation.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.LogPrinter
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.subscribeBy
import vn.htv.fresher.todoapp.presentation.common.BaseViewModel
import timber.log.Timber
import io.reactivex.rxkotlin.plusAssign
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.R
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.usecase.category.GetCategoryListUseCase
import vn.htv.fresher.todoapp.domain.usecase.category.SaveCategoryUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.*

enum class TaskGroup {
  MY_DAY,
  IMPORTANT,
  DEADLINE,
  ACTION;

  val groupName: Int
    @StringRes get() = when (this) {
      MY_DAY    -> R.string.task_group_my_day
      IMPORTANT -> R.string.task_group_important
      DEADLINE  -> R.string.task_group_deadline
      ACTION    -> R.string.task_group_action
    }

  val groupIcon: Int
    @StringRes get() = when (this) {
      MY_DAY    -> R.drawable.ic_my_day
      IMPORTANT -> R.drawable.ic_important
      DEADLINE  -> R.drawable.ic_deadline
      ACTION    -> R.drawable.ic_action
    }
}

enum class MainItemType(val value: Int) {
  MAIN_ITEM(0),
  SEPARATOR(1);

  companion object {
    fun from(value: Int) = values().first { it.value == value }
  }
}

sealed class MainItem(val type: MainItemType) {
  data class Item(val model: MainItemModel): MainItem(MainItemType.MAIN_ITEM)

  object Separator: MainItem(MainItemType.SEPARATOR)
}

data class MainItemModel(
  val iconId      : Int? = null,
  val name        : String,
  val taskNumber  : Int = 0
)

class MainViewModel(
  private val context                 : Context,
  private val getTaskListUseCase      : GetTaskListUseCase,
  private val getCategoryListUseCase  : GetCategoryListUseCase,
  private val saveCategoryUseCase     : SaveCategoryUseCase,
  private val saveTaskUseCase         : SaveTaskUseCase
) : BaseViewModel() {

  val mainItemList: LiveData<List<MainItem>> get() = _mainItemList
  private val _mainItemList = MutableLiveData<List<MainItem>>()

  fun loadData() {
    val getTaskObservable     = getTaskListUseCase()
    val getCategoryObservable = getCategoryListUseCase()
    val zipper = BiFunction<List<TaskModel>, List<CategoryModel>, List<MainItem>> { tasks, categories ->
      val list = mutableListOf<MainItem>()
      val taskGroupList = generateTaskGroup(tasks)

      list.addAll(taskGroupList)
      list.add(MainItem.Separator)

      val categoryItems = categories.map { category ->
        MainItem.Item(
          MainItemModel(
            name = category.name,
            taskNumber = tasks.filter { it.catId == category.id }.size
          )
        )
      }
      list.addAll(categoryItems)
      list
    }

    disposables += Single.zip(getTaskObservable, getCategoryObservable, zipper)
      .subscribeBy(
        onSuccess = {
          _mainItemList.postValue(it)
        },
        onError   = {
          Timber.i("Cannot post value")
        }
      )
  }

  private fun generateTaskGroup(tasks: List<TaskModel>): List<MainItem> {
    val list = mutableListOf<MainItem>()

    val myDayItem = MainItemModel(
      iconId      = TaskGroup.MY_DAY.groupIcon,
      name        = context.getString(TaskGroup.MY_DAY.groupName),
      taskNumber  = tasks.filter { it.myDay }.size
    )
    list.add(MainItem.Item(myDayItem))

    val importantItem = MainItemModel(
      iconId      = TaskGroup.IMPORTANT.groupIcon,
      name        = context.getString(TaskGroup.IMPORTANT.groupName),
      taskNumber  = tasks.filter { it.important }.size
    )
    list.add(MainItem.Item(importantItem))

    val deadlineItem =MainItemModel(
      iconId      = TaskGroup.DEADLINE.groupIcon,
      name        = context.getString(TaskGroup.DEADLINE.groupName),
      taskNumber  = tasks.filter { it.deadline != null }.size
    )
    list.add(MainItem.Item(deadlineItem))

    val actionItem =MainItemModel(
      iconId      = TaskGroup.ACTION.groupIcon,
      name        = context.getString(TaskGroup.ACTION.groupName),
      taskNumber  = tasks.filter { it.catId == null }.size
    )
    list.add(MainItem.Item(actionItem))

    return list
  }
}