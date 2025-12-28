package com.oyj.portfolio.admin.context.introduction.service

import com.oyj.portfolio.admin.context.introduction.form.IntroductionForm
import com.oyj.portfolio.admin.data.TableDTO
import com.oyj.portfolio.domain.entity.Introduction
import com.oyj.portfolio.domain.repository.IntroductionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: IntroductionForm) {
        val introduction = form.toEntity()
        introductionRepository.save(introduction)
    }

    @Transactional
    fun update(id: Long, form: IntroductionForm) {
        val introduction = form.toEntity(id)
        introductionRepository.save(introduction)
    }
}