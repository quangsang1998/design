package vn.htv.fresher.todoapp.domain.usecase.subtask

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.repository.SubTaskRepository

class DeleteSubTaskUseCase (
  private val subTaskRepository: SubTaskRepository,
  private val model: SubTaskModel
) {
    operator fun invoke(): Completable {
      return subTaskRepository.deleteSubTask(model)
    }
}
