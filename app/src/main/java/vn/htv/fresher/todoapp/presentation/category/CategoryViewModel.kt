package vn.htv.fresher.todoapp.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.usecase.category.GetCategoryUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskListUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.SaveTaskUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.UpdateTaskUseCase
import vn.htv.fresher.todoapp.presentation.common.BaseViewModel

// enum class MainTaskItemType(val v: Int) {
//  NOT_FINISH(0),
//  FINISHED_STATE(1);
//  companion object {
//    fun from(value: Int) = values().first { it.v == value }
//  }
// }
//
// sealed class MainTaskItem(val type: MainTaskItemType) {
//  data class Item(val model: MainTaskItemModel): MainTaskItem(MainTaskItemType.NOT_FINISH)
//
//  object TaskFinished: MainTaskItem(MainTaskItemType.FINISHED_STATE)
// }
//
// data class MainTaskItemModel(
//  val finished    : Boolean,
//  val nameTask    : String,
//  val important  : Boolean
// ) {
//
// }

class CategoryViewModel(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getTaskListUseCase: GetTaskListUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : BaseViewModel() {

//  val setImportant: LiveData<Boolean> get() = _setImportant
//  private _val _setImportant = MutableLiveData<Boolean>(

    val updateImportantCompleted: LiveData<Boolean> get() = _updateImportantCompleted
    private val _updateImportantCompleted = MutableLiveData<Boolean>()

    val updateFinishedCompleted: LiveData<Boolean> get() = _updateFinishedCompleted
    private val _updateFinishedCompleted = MutableLiveData<Boolean>()

    val updateNameCompleted: LiveData<String> get() = _updateNameCompleted
    private val _updateNameCompleted = MutableLiveData<String>()

    val addTaskCompleted: LiveData<Boolean> get() = _addTaskCompleted
    private val _addTaskCompleted = MutableLiveData<Boolean>()
    val itemCategory: LiveData<CategoryModel> get() = _itemCategory
    private val _itemCategory = MutableLiveData<CategoryModel>()

    val itemList: LiveData<List<TaskModel>> get() = _itemList
    private val _itemList = MutableLiveData<List<TaskModel>>()

//    val itemTask: LiveData<TaskModel> get() = _itemTask
//    private val _itemTask = MutableLiveData<TaskModel>()

    var categoryId: Long? = null

    //  val catItemList: LiveData<List<CategoryModel>> get() = _catItemList
//  private val _catItemList = MutableLiveData<List<CategoryModel>>()

    fun loadCategory() {
        val id = categoryId ?: return

        disposables += getCategoryUseCase(id)
            .subscribeBy(
                onSuccess = {
                    _itemCategory.postValue(it)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }
    fun loadData() {
     val id = categoryId ?: return
//  val getTaskObservable = getTaskListUseCase()
//  val zipper = BiFunction<List<TaskModel>, List<TaskModel>, List<TaskModel>> { tasks1, tasks2 ->
//    val list = mutableListOf<TaskModel>()
//
//    list.add(MainTaskItem.TaskFinished)
//
//    val taskItems = tasks1.map { t ->
//      MainTaskItem.Item(
//        MainTaskItemModel(
//          finished = t.finished,
//          nameTask = t.name,
//          important = t.important
//        )
//      )
//    }
//    list.addAll(taskItems)
//    list
//  }
        disposables += getTaskListUseCase(id.toInt())
            .subscribeBy(
                onSuccess = {
                    _itemList.postValue(it)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }
//    fun loadData2() {
//        val id = categoryId ?: return
//        disposables += getTaskUseCase(id.toInt())
//            .subscribeBy(
//                onSuccess = {
//                    _itemTask.postValue(it)
//                },
//                onError = {
//                    Timber.e("error")
//                }
//            )
//    }
//  disposables += getCategoryListUseCase()
//      .subscribeBy(
//           onSuccess = {
//            _catItemList.postValue(it)
//          },
//          onError = {
//            Timber.e("error")
//          }
//      )

    fun updateComplete(model: TaskModel) {
        updateTaskFinished(model.copy(finished = !model.finished))
    }

    fun updateImportant(model: TaskModel) {
        updateTaskImportant(model.copy(important = !model.important))
    }

//    fun updateTaskName(model: TaskModel) {
//        disposables += updateTaskUseCase(model)
//            .subscribeBy(
//                onComplete = {
//                    _updateNameCompleted.postValue()
//                },
//                onError = {
//                    Timber.e("error")
//                }
//            )
//    }
    fun updateTaskFinished(model: TaskModel) {
        disposables += updateTaskUseCase(model)
            .subscribeBy(
                onComplete = {
                    _updateFinishedCompleted.postValue(true)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }

    fun updateTaskImportant(model: TaskModel) {

        disposables += updateTaskUseCase(model)
            .subscribeBy(
                onComplete = {
                    _updateImportantCompleted.postValue(true)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }

    fun addNewTask(model: TaskModel) {
        disposables += saveTaskUseCase(model)
            .subscribeBy(
                onComplete = {
                    _addTaskCompleted.postValue(true)
                    Timber.i("saved task success")
                },
                onError = {
                    Timber.e(it.toString())
                }
            )
    }

    //  fun saveTaskList(): List<TaskModel>{
//    var list = ArrayList<TaskModel>()
//    list.add(TaskModel(
//        id = 1,
//        catId = 1,
//        name = "",
//        finished = true,
//        deadline = LocalDateTime.now(),
//        myDay = true,
//        important = true,
//        reminder = LocalDateTime.now(),
//        repeat = 1,
//        createdAt = LocalDateTime.now(),
//        note = ""))
//    return  list
//  }
//  fun insertCategory() {
//    val model = CategoryModel(
//        name = "category",
//        id = 1,
//        icon = "",
//        createdAt = LocalDateTime.now()
//    )
//  disposables += saveCategoryUseCase(model)
//      .subscribeBy(
//          onComplete = {
//            Timber.i("saved task success")
//          },
//          onError = {
//            Timber.e(" error")
//          }
//      )
//  }
//    fun insertTask() {
//        val model = TaskModel(
//            name = "task",
//            catId = 1,
//            finished = false,
//            deadline = LocalDateTime.now(),
//            myDay = true,
//            important = true,
//            reminder = LocalDateTime.now(),
//            repeat = 1,
//            createdAt = LocalDateTime.now(),
//            note = ""
//        )
//        disposables += saveTaskUseCase(model)
//            .subscribeBy(
//                onComplete = {
//                    Timber.i("saved task success")
//                },
//                onError =
//                {
//                    Timber.e(" error")
//                }
//            )
//    }
}
