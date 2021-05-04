package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime

data class TaskModel(
  val id         : Int? = null,
  val catId      : Int? = null,
  val name       : String,
  var finished   : Boolean = false,
  val deadline   : LocalDateTime? = null,
  val myDay      : Boolean = false,
  val important  : Boolean = false,
  val reminder   : LocalDateTime? = null,
  val repeat     : Int? = null,
  val createdAt  : LocalDateTime,
  val note       : String? = null
)