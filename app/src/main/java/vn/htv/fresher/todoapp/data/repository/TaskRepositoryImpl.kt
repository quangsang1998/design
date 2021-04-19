package vn.htv.fresher.todoapp.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.dao.TaskDao
import vn.htv.fresher.todoapp.data.db.entity.Task
import vn.htv.fresher.todoapp.data.mapper.toModel
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.repository.TaskRepository
import vn.htv.fresher.todoapp.util.rx.SchedulerProvider

class TaskRepositoryImpl(
  private val taskDao           : TaskDao,
  private val schedulerProvider : SchedulerProvider
) : TaskRepository {

  override fun getTaskList(): Single<List<TaskModel>> {
    return taskDao.getAll().map { list ->
      list.map { it.toModel() }
    }
      .observeOn(schedulerProvider.io())
      .subscribeOn(schedulerProvider.io())
  }

  override fun saveTask(model: TaskModel): Completable {
    val entity = Task.fromModel(model)

    return taskDao.insert(entity)
      .observeOn(schedulerProvider.io())
      .subscribeOn(schedulerProvider.io())
  }
}