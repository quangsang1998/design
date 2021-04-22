package vn.htv.fresher.todoapp.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.CategoryModel

interface CategoryRepository {
  fun deleteCategory(id: Int): Completable

  fun getCategoryList(): Single<List<CategoryModel>>

  fun saveCategory(model: CategoryModel): Completable

  fun updateCategory(model: CategoryModel): Completable
}