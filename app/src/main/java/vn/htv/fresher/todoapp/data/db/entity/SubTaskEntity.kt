package vn.htv.fresher.todoapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime
import vn.htv.fresher.todoapp.domain.model.SubTaskModel

@Entity (tableName = SubTask.NAME)
data class SubTask(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)         val id: Int,
    @ColumnInfo(name = COLUMN_TASKID)     val taskid: Int,
    @ColumnInfo(name = COLUMN_NAME)       val name: String,
    @ColumnInfo(name = COLUMN_FINISHED)   val finished: Boolean? = null,
    @ColumnInfo(name = COLUMN_CREATEDAT)  val createdat: LocalDateTime
){
    companion object {
        const val NAME             = "subtask"
        const val COLUMN_ID        = "id"
        const val COLUMN_TASKID    = "taskid"
        const val COLUMN_NAME      = "name"
        const val COLUMN_FINISHED  = "finished"
        const val COLUMN_CREATEDAT = "createdat"

        fun fromModel(model: SubTaskModel) = SubTask(
            id        = model.id,
            taskid    = model.taskid,
            name      = model.name,
            finished  = model.finished,
            createdat = model.createdat
        )
    }
}