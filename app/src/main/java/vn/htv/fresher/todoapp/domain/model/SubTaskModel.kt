package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime

data class SubTaskModel(
  val id         : Int,
  val taskId     : Int,
  val name       : String,
  val finished   : Boolean? = null,
  val createdAt  : LocalDateTime
)