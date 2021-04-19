package vn.htv.fresher.todoapp.domain.model

import org.threeten.bp.LocalDate
import java.time.LocalDateTime

data class CategoryModel(
    val id: Int,
    val name: String,
    val icon: String? = null,
    val createdat: org.threeten.bp.LocalDateTime
)
