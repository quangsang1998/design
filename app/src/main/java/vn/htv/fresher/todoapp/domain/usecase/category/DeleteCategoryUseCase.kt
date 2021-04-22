package vn.htv.fresher.todoapp.domain.usecase.category

import io.reactivex.Completable
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.model.SubTaskModel
import vn.htv.fresher.todoapp.domain.repository.CategoryRepository

class DeleteCategoryUseCase(
  private val categoryRepository  : CategoryRepository,
  private val model  : CategoryModel
) {
    operator fun invoke()  : Completable {
      return categoryRepository.deleteCategory(model)
    }
}