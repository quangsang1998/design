package vn.htv.fresher.todoapp.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.CategoryModel

interface CategoryRepository {
  fun getCategoryList(): Single<List<CategoryModel>>

  fun saveCategory(model: CategoryModel): Completable

  fun insertCategory(model: CategoryModel): Completable

  fun updateCategory(model: CategoryModel): Completable

  fun deleteCategory(model: CategoryModel): Completable
}