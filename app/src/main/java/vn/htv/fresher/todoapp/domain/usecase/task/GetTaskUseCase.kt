package vn.htv.fresher.todoapp.domain.usecase.task

import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.repository.TaskRepository

class GetTaskUseCase(
  private val taskRepository: TaskRepository
) {
  operator fun invoke(id: Int): Single<TaskModel> {
    return taskRepository.get(id)
  }
}