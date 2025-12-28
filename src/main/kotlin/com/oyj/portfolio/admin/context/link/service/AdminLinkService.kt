package com.oyj.portfolio.admin.context.link.service

import com.oyj.portfolio.admin.context.link.form.LinkForm
import com.oyj.portfolio.admin.data.TableDTO
import com.oyj.portfolio.domain.repository.LinkRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    fun getLinkTable(): TableDTO {
        val classInfo = LinkRepository::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: LinkForm) {
        val link = form.toEntity()
        linkRepository.save(link)
    }

    @Transactional
    fun update(id: Long, form: LinkForm) {
        val link = form.toEntity(id)
        linkRepository.save(link)
    }
}