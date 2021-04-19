package vn.htv.fresher.todoapp.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.TaskModel

interface TaskRepository {

  fun getTaskList(): Single<List<TaskModel>>

  fun saveTask(model: TaskModel): Completable

  fun insertTask(model: TaskModel): Completable

  fun updateTask(model: TaskModel): Completable

  fun deleteTask(model: TaskModel): Completable
}