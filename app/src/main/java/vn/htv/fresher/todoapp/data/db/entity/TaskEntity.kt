package vn.htv.fresher.todoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.domain.model.TaskModel

/**
 * Task Entity
 */
@Entity(tableName = Task.NAME)
data class Task(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = COLUMN_ID)         val id        : Int? = null,
  @ColumnInfo(name = COLUMN_CAT_ID)     val catId     : Int? = null,
  @ColumnInfo(name = COLUMN_NAME)       val name      : String,
  @ColumnInfo(name = COLUMN_FINISHED)   val finished  : Boolean,
  @ColumnInfo(name = COLUMN_DEADLINE)   val deadline  : LocalDateTime? = null,
  @ColumnInfo(name = COLUMN_MY_DAY)     val myDay     : Boolean,
  @ColumnInfo(name = COLUMN_IMPORTANT)  val important : Boolean,
  @ColumnInfo(name = COLUMN_REMINDER)   val reminder  : LocalDateTime? = null,
  @ColumnInfo(name = COLUMN_REPEAT)     val repeat    : Int? = null,
  @ColumnInfo(name = COLUMN_CREATED_AT) val createdAt : LocalDateTime,
  @ColumnInfo(name = COLUMN_NOTE)       val note      : String? = null,
) {
  companion object {
    const val NAME              = "task"
    const val COLUMN_ID         = "id"
    const val COLUMN_CAT_ID     = "cat_id"
    const val COLUMN_NAME       = "name"
    const val COLUMN_FINISHED   = "finished"
    const val COLUMN_DEADLINE   = "deadline"
    const val COLUMN_MY_DAY     = "my_day"
    const val COLUMN_IMPORTANT  = "important"
    const val COLUMN_REMINDER   = "reminder"
    const val COLUMN_REPEAT     = "repeat"
    const val COLUMN_CREATED_AT = "created_at"
    const val COLUMN_NOTE       = "note"

    /**
     * Create TaskEntity from TaskModel
     */
    fun fromModel(model: TaskModel) = Task(
      id         = model.id,
      catId      = model.catId,
      name       = model.name,
      finished   = model.finished,
      deadline   = model.deadline,
      myDay      = model.myDay,
      important  = model.important,
      reminder   = model.reminder,
      repeat     = model.repeat,
      createdAt  = model.createdAt,
      note       = model.note
    )
  }
}