package vn.htv.fresher.todoapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.htv.fresher.todoapp.data.repository.TaskRepositoryImpl
import vn.htv.fresher.todoapp.domain.repository.TaskRepository
import vn.htv.fresher.todoapp.domain.usecase.task.*
import vn.htv.fresher.todoapp.presentation.main.MainViewModel
import vn.htv.fresher.todoapp.util.rx.AppSchedulerProvider
import vn.htv.fresher.todoapp.util.rx.SchedulerProvider

val appModule = module {

  single<SchedulerProvider>(createdAtStart = true) { AppSchedulerProvider() }

  // Repository
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  single<TaskRepository> { TaskRepositoryImpl(get(), get()) }


  // UseCase
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  factory { DeleteTaskUseCase(get())      }
  factory { GetTaskByCatIdUseCase(get())  }
  factory { GetTaskListUseCase(get())     }
  factory { GetTaskUseCase(get())         }
  factory { InsertTaskUseCase(get())      }
  factory { UpdateTaskUseCase(get())      }


  // ViewModel
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  viewModel { MainViewModel() }

}