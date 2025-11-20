package com.oyj.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(
    content: String,
    isActive: Boolean = true,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    var id: Long? = null

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean = true) {
        this.content = content
        this.isActive = isActive
    }
}