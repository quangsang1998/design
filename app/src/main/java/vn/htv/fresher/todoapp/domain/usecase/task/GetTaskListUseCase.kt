package vn.htv.fresher.todoapp.domain.usecase.task

import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.TaskModel
import vn.htv.fresher.todoapp.domain.repository.TaskRepository

class GetTaskListUseCase(
  private val taskRepository: TaskRepository
) {
  operator fun invoke(catId: Int? = null): Single<List<TaskModel>> {
    return taskRepository.getTaskList(catId)
  }
}