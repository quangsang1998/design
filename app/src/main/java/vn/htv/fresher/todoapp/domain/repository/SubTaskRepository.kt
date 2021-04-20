package vn.htv.fresher.todoapp.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.model.TaskModel

interface SubTaskRepository {
  fun getSubTaskList(): Single<List<SubTaskModel>>

  fun saveSubTask(model: SubTaskModel): Completable

  fun insertSubTask(model: SubTaskModel): Completable

  fun updateSubTask(model: SubTaskModel): Completable

  fun deleteSubTask(model: SubTaskModel): Completable

  fun getByTaskId(id: Int): Single<List<SubTaskModel>>
}