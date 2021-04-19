package vn.htv.fresher.todoapp.data.mapper

import vn.htv.fresher.todoapp.data.db.entity.Category
import vn.htv.fresher.todoapp.domain.model.CategoryModel

fun Category.toModel() = CategoryModel(
  id         = id,
  name       = name,
  icon       = icon,
  createdAt  = createdAt
)