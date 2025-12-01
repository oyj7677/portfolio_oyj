package com.oyj.portfolio.presentation.dto

import com.oyj.portfolio.domain.entity.Link

class LinkDTO(
    val name: String,
    val content: String,
) {
    constructor(link: Link) : this(
        name = link.name.lowercase(),
        content = link.content
    )
}