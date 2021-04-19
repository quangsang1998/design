package vn.htv.fresher.todoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import vn.htv.fresher.todoapp.domain.model.TaskModel

/**
 * Task Entity
 */
@Entity(tableName = Task.NAME)
data class Task(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = COLUMN_ID)   val id: Int? = null,
  @ColumnInfo(name = COLUMN_NAME) val name: String
) {
  companion object {
    const val NAME        = "task"
    const val COLUMN_ID   = "id"
    const val COLUMN_NAME = "name"

    /**
     * Create TaskEntity from TaskModel
     */
    fun fromModel(model: TaskModel) = Task(
      name = model.name
    )
  }
}