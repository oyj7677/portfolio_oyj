package com.oyj.portfolio.admin.context.link.service

import com.oyj.portfolio.admin.data.TableDTO
import com.oyj.portfolio.domain.entity.Introduction
import com.oyj.portfolio.domain.repository.IntroductionRepository
import com.oyj.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service


@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
){

    fun getLinkTable(): TableDTO {
        val classInfo = LinkRepository::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}