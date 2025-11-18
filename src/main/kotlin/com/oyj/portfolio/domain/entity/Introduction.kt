package com.oyj.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction(
    content: String,
    isActive: Boolean = true,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null

    var content: String = content

    var isActive: Boolean = isActive
}