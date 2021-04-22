package vn.htv.fresher.todoapp.domain.usecase.subtask

import io.reactivex.Completable
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.repository.SubTaskRepository

class UpdateSubTaskUseCase(
  private val subTaskRepository  : SubTaskRepository,
  private val model              : SubTaskModel
) {
    operator fun invoke(): Completable {
      return subTaskRepository.updateSubTask(model)
    }
}