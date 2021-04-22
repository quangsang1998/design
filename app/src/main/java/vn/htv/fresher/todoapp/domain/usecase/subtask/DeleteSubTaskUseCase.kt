package vn.htv.fresher.todoapp.domain.usecase.subtask

import io.reactivex.Completable
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.repository.SubTaskRepository

class DeleteSubTaskUseCase(
  private val subTaskRepository: SubTaskRepository
) {
    operator fun invoke(model: SubTaskModel): Completable {
      return subTaskRepository.deleteSubTask(model)
    }
}
