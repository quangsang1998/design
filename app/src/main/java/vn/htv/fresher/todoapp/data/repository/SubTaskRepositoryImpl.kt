package vn.htv.fresher.todoapp.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.dao.SubTaskDao
import vn.htv.fresher.todoapp.data.db.entity.SubTask
import vn.htv.fresher.todoapp.data.mapper.toModel
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.repository.SubTaskRepository
import vn.htv.fresher.todoapp.util.rx.SchedulerProvider

class SubTaskRepositoryImpl (
  private val subTaskDao         : SubTaskDao,
  private val schedulerProvider  : SchedulerProvider
) : SubTaskRepository {
  override fun deleteSubTask(model  : SubTaskModel)  : Completable {
    val entity = SubTask.fromModel(model)

    return subTaskDao.delete(entity)
      .observeOn(schedulerProvider.io())
      .subscribeOn(schedulerProvider.io())
  }

  override fun getByTaskId(taskId  : Int?)  : Single<List<SubTaskModel>> {
    if(taskId == null) {
      return subTaskDao.getAll()
        .map { list -> list.map { it.toModel() } }
        .observeOn(schedulerProvider.io())
        .subscribeOn(schedulerProvider.io())
    }
    else {
      return subTaskDao.getByTaskId(taskId)
        .map { list -> list.map { it.toModel() } }
        .observeOn(schedulerProvider.io())
        .subscribeOn(schedulerProvider.io())
    }
  }

  override fun saveSubTask(model  : SubTaskModel)  : Completable {
    val entity = SubTask.fromModel(model)

    return subTaskDao.insert(entity)
      .observeOn(schedulerProvider.io())
      .subscribeOn(schedulerProvider.io())
  }

  override fun updateSubTask(model  : SubTaskModel)  : Completable {
    val entity = SubTask.fromModel(model)

    return subTaskDao.update(entity)
      .observeOn(schedulerProvider.io())
      .subscribeOn(schedulerProvider.io())
  }
}

