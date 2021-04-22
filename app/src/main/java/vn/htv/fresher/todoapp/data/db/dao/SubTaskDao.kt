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

  @Delete
  fun delete(entity: SubTask): Completable

  @Insert
  fun insert(entity: SubTask): Completable

  @Query("SELECT * FROM ${SubTask.NAME}")
  fun getAll(): Single<List<SubTask>>

  @Query("SELECT * FROM ${SubTask.NAME} WHERE ${SubTask.COLUMN_ID} = :taskId")
  fun getByTaskId(taskId: Int): Single<List<SubTask>>

  @Update
  fun update(entity: SubTask): Completable

}