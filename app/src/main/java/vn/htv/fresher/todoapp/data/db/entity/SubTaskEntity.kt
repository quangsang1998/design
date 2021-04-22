package vn.htv.fresher.todoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.domain.model.SubTaskModel

@Entity (tableName = SubTask.NAME)
data class SubTask(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = COLUMN_ID)          val id         : Int,
  @ColumnInfo(name = COLUMN_TASK_ID)     val taskId     : Int? = null,
  @ColumnInfo(name = COLUMN_NAME)        val name       : String,
  @ColumnInfo(name = COLUMN_FINISHED)    val finished   : Boolean? = null,
  @ColumnInfo(name = COLUMN_CREATED_AT)  val createdAt  : LocalDateTime
) {
  companion object {
    const val NAME               = "sub_task"
    const val COLUMN_ID          = "id"
    const val COLUMN_TASK_ID     = "task_id"
    const val COLUMN_NAME        = "name"
    const val COLUMN_FINISHED    = "finished"
    const val COLUMN_CREATED_AT  = "created_at"

    fun fromModel(model: SubTaskModel) = SubTask(
      id         = model.id,
      taskId     = model.taskId,
      name       = model.name,
      finished   = model.finished,
      createdAt  = model.createdAt
    )
  }
}