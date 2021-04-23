package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskListUseCase

data class CategoryModel(
  val id         : Int? = null,
  val name       : String,
  val icon       : String? = null,
  val createdAt  : LocalDateTime
)
