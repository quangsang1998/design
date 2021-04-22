package vn.htv.fresher.todoapp.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import vn.htv.fresher.todoapp.data.db.ToDoDatabase
import vn.htv.fresher.todoapp.util.constant.Constant

val dbModule = module {

  single(createdAtStart = true) {
    Room.databaseBuilder(
      androidContext(),
      ToDoDatabase::class.java,
      Constant.DB_NAME
    ).build()
  }

  single {
    get<ToDoDatabase>().taskDao()
    get<ToDoDatabase>().subTaskDao()
    get<ToDoDatabase>().categoryDao()
  }
}