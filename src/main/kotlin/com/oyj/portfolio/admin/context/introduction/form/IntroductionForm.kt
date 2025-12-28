package com.oyj.portfolio.admin.context.introduction.form

import com.oyj.portfolio.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank

data class IntroductionForm(
    @field:NotBlank(message = "필수값입니다")
    val content: String,
    val isActive: Boolean,
) {
    fun toEntity(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toEntity(id: Long): Introduction {
        val introduction = toEntity()
        introduction.id = id
        return introduction
    }
}