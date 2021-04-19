package vn.htv.fresher.todoapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.entity.Task

@Dao
interface TaskDao {

  @Query("SELECT * FROM ${Task.NAME}")
  fun getAll(): Single<List<Task>>

  @Insert
  fun insert(entity: Task): Completable
}