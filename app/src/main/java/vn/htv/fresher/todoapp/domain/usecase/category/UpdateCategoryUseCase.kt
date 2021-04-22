package vn.htv.fresher.todoapp.domain.usecase.category

import io.reactivex.Completable
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.repository.CategoryRepository

class UpdateCategoryUseCase(
  private val categoryRepository: CategoryRepository,
) {
    operator fun invoke(model: CategoryModel): Completable {
      return categoryRepository.updateCategory(model)
    }
}