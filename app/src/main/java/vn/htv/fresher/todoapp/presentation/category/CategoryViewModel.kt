package vn.htv.fresher.todoapp.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.usecase.category.*
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskListUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.SaveTaskUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.UpdateTaskUseCase
import vn.htv.fresher.todoapp.presentation.common.BaseViewModel


class CategoryViewModel(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getTaskListUseCase: GetTaskListUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val updateCategoryUseCase: UpdateCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase,
) : BaseViewModel() {

    val updateTaskCompleted: LiveData<Boolean> get() = _updateTaskCompleted
    private val _updateTaskCompleted = MutableLiveData<Boolean>()

    val updateCategoryCompleted: LiveData<Boolean> get() = _updateCategoryCompleted
    private val _updateCategoryCompleted = MutableLiveData<Boolean>()

    val deleteCategoryCompleted: LiveData<Boolean> get() = _deleteCategoryCompleted
    private val _deleteCategoryCompleted = MutableLiveData<Boolean>()

    val addTaskCompleted: LiveData<Boolean> get() = _addTaskCompleted
    private val _addTaskCompleted = MutableLiveData<Boolean>()

    val itemCategory: LiveData<CategoryModel> get() = _itemCategory
    private val _itemCategory = MutableLiveData<CategoryModel>()

    val itemList: LiveData<List<TaskModel>> get() = _itemList
    private val _itemList = MutableLiveData<List<TaskModel>>()


    var categoryId: Long? = null

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

    fun updateFinished(model: TaskModel) {
        updateTask(model.copy(finished = !model.finished))
    }

    fun updateImportant(model: TaskModel) {
        updateTask(model.copy(important = !model.important))
    }

    fun updateName(model: CategoryModel) {
        updateCategory(model.copy(name = model.name))
    }

    fun updateTask(model: TaskModel) {

        disposables += updateTaskUseCase(model)
            .subscribeBy(
                onComplete = {
                    _updateTaskCompleted.postValue(true)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }

    fun updateCategory(model: CategoryModel) {
        disposables += updateCategoryUseCase(model)
            .subscribeBy(
                onComplete = {
                    _updateCategoryCompleted.postValue(true)
                },
                onError = {
                    Timber.e("error")
                }
            )
    }

    fun deleteCategory(model: CategoryModel) {
        disposables += deleteCategoryUseCase(model)
            .subscribeBy(
                onComplete = {
                    _deleteCategoryCompleted.postValue(true)
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
