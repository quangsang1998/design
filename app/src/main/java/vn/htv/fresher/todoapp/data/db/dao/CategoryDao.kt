package vn.htv.fresher.todoapp.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import vn.htv.fresher.todoapp.data.db.entity.Category
import vn.htv.fresher.todoapp.data.db.entity.Task

interface CategoryDao {

  @Query("SELECT * FROM ${Category.NAME}")
  fun getAll(): Single<List<Category>>

  @Insert
  fun insert(entity: Category): Completable
  @Delete
  fun delete(entity: Category): Completable
  @Update
  fun update(entity: Category ): Completable

}