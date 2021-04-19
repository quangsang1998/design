package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDateTime

data class SubTaskModel(
    val id: Int,
    val taskid: Int,
    val name: String,
    val finished: Boolean? = null,
    val createdat: LocalDateTime
)