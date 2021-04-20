package vn.htv.fresher.todoapp.data.db.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.entity.Task

@Dao
interface TaskDao {
  @Delete
  fun delete(entity: Task): Completable

  @Query("SELECT * FROM ${Task.NAME} WHERE id =:id")
  fun get(id: Int): Single<Task>

  @Query("SELECT * FROM ${Task.NAME}")
  fun getAll(): Single<List<Task>>

  @Query("SELECT * FROM ${Task.NAME} WHERE id=:catId")
  fun getByCatId(catId: Int): Single<List<Task>>

  @Insert
  fun insert(entity: Task): Completable

  @Update
  fun update(entity: Task): Completable
}