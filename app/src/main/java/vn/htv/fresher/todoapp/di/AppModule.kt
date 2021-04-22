package vn.htv.fresher.todoapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.htv.fresher.todoapp.data.repository.CategoryRepositoryImpl
import vn.htv.fresher.todoapp.data.repository.SubTaskRepositoryImpl
import vn.htv.fresher.todoapp.data.repository.TaskRepositoryImpl
import vn.htv.fresher.todoapp.domain.repository.CategoryRepository
import vn.htv.fresher.todoapp.domain.repository.SubTaskRepository
import vn.htv.fresher.todoapp.domain.repository.TaskRepository
import vn.htv.fresher.todoapp.domain.usecase.task.GetTaskListUseCase
import vn.htv.fresher.todoapp.domain.usecase.task.SaveTaskUseCase
import vn.htv.fresher.todoapp.presentation.main.MainViewModel
import vn.htv.fresher.todoapp.util.rx.AppSchedulerProvider
import vn.htv.fresher.todoapp.util.rx.SchedulerProvider

val appModule = module {

  single<SchedulerProvider>(createdAtStart = true) { AppSchedulerProvider() }

  // Repository
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  single<TaskRepository> { TaskRepositoryImpl(get(), get()) }
  single<SubTaskRepository> { SubTaskRepositoryImpl(get(), get()) }
  single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }

  // UseCase
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  factory { GetTaskListUseCase(get()) }
  factory { SaveTaskUseCase(get()) }


  // ViewModel
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  viewModel { MainViewModel(get(), get()) }

}