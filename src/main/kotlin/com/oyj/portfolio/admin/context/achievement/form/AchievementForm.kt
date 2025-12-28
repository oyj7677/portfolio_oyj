package com.oyj.portfolio.admin.context.achievement.form

import com.oyj.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(

    @field:NotBlank(message = "필수값입니다")
    val title: String,
    @field:NotBlank(message = "필수값입니다")
    val description: String,
    @field:NotBlank(message = "필수값입니다")
    val host: String,
    @field:NotBlank(message = "필수값입니다")
    val achieveData: String,
    val isActive: Boolean,
) {
    fun toEntity(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achieveData),
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Achievement {
        val achievement = toEntity()
        achievement.id = id
        return achievement
    }
}