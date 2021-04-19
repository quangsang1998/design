package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime

data class TaskModel(
  val id          : Int? = null,
  val cat_id      : Int,
  val name        : String,
  val finished    : Boolean,
  val deadline    : LocalDateTime,
  val my_day      : Boolean,
  val important   : Boolean,
  val reminder    : LocalDateTime,
  val repeat      : Int,
  val created_at  : LocalDateTime,
  val note        : String,
)