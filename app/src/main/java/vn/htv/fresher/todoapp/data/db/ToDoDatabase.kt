package vn.htv.fresher.todoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import vn.htv.fresher.todoapp.data.db.converter.TypeConverter
import vn.htv.fresher.todoapp.data.db.dao.TaskDao
import vn.htv.fresher.todoapp.data.db.entity.Task

@Database(
  entities = [
    Task::class
  ],
  version = 1
)
@TypeConverters(TypeConverter::class)
abstract class ToDoDatabase : RoomDatabase() {

  abstract fun taskDao(): TaskDao
}