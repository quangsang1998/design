package vn.htv.fresher.todoapp.data.mapper

import vn.htv.fresher.todoapp.data.db.entity.SubTask
import vn.htv.fresher.todoapp.domain.model.SubTaskModel

fun SubTask.toModel() = SubTaskModel(
  id         = id,
  taskId     = taskId,
  name       = name,
  finished   = finished,
  createdAt  = createdAt
)