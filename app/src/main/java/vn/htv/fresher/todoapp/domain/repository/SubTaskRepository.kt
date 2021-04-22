package vn.htv.fresher.todoapp.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.SubTaskModel

interface SubTaskRepository {
  fun deleteSubTask(model  : SubTaskModel)  : Completable

  fun getByTaskId(taskId  : Int?)  : Single<List<SubTaskModel>>

  fun saveSubTask(model  : SubTaskModel)  : Completable

  fun updateSubTask(model  : SubTaskModel)  : Completable
}