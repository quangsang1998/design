package vn.htv.fresher.todoapp.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.entity.SubTask
import vn.htv.fresher.todoapp.data.db.entity.Task

interface SubTaskDao {
  @Query("SELECT * FROM ${SubTask.NAME}")
  fun getAll(): Single<List<SubTask>>

  @Insert
  fun insert(entity: SubTask): Completable
  @Delete
  fun delete(entity: SubTask): Completable
  @Update
  fun update(entity: SubTask): Completable
  @Query("SELECT *FROM ${SubTask.NAME} WHERE id LIKE:id")
  fun getByTaskId(id: Int): Single<List<SubTask>>
}