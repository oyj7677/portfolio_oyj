package com.oyj.portfolio.domain.repository

import com.oyj.portfolio.domain.constant.SkillType
import com.oyj.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long> {
    // select * from Skill where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Skill>

    // select * from Skill where lower(name) = lower(:name) and skill_type  = :type
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>
}