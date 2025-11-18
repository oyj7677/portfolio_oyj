package com.oyj.portfolio.domain.repository

import com.oyj.portfolio.domain.entity.Achievement
import com.oyj.portfolio.domain.entity.HttpInterface
import com.oyj.portfolio.domain.entity.Introduction
import com.oyj.portfolio.domain.entity.Link
import com.oyj.portfolio.domain.entity.Project
import com.oyj.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {

}