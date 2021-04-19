package vn.htv.fresher.todoapp.data.mapper

import vn.htv.fresher.todoapp.data.db.entity.Task
import vn.htv.fresher.todoapp.domain.model.TaskModel

/**
 * Convert Task entity to Task model
 */
fun Task.toModel() = TaskModel(
  id          = id,
  cat_id      = cat_id,
  name        = name,
  finished    = finished,
  deadline    = deadline,
  my_day      = my_day,
  important   = important,
  reminder    = reminder,
  repeat      = repeat,
  created_at  = created_at,
  note        = note
)