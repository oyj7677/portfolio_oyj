package com.oyj.portfolio.admin.context.achievement.service

import com.oyj.portfolio.admin.context.achievement.form.AchievementForm
import com.oyj.portfolio.admin.data.TableDTO
import com.oyj.portfolio.domain.entity.Achievement
import com.oyj.portfolio.domain.repository.AchievementRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }

}