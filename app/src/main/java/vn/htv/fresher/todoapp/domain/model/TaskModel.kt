package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime

data class TaskModel(
  val id         : Int? = null,
  val catId      : Int,
  val name       : String,
  val finished   : Boolean,
  val deadline   : LocalDateTime,
  val myDay      : Boolean,
  val important  : Boolean,
  val reminder   : LocalDateTime,
  val repeat     : Int,
  val createdAt  : LocalDateTime,
  val note       : String
)