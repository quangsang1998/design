package vn.htv.fresher.todoapp.domain.usecase.category

import io.reactivex.Single
import vn.htv.fresher.todoapp.domain.model.CategoryModel
import vn.htv.fresher.todoapp.domain.repository.CategoryRepository

class SaveCategoryUseCase(
  private val categoryRepository: CategoryRepository
) {
    operator fun invoke(model: CategoryModel): Single<Long> {
      return categoryRepository.saveCategory(model)
    }
}