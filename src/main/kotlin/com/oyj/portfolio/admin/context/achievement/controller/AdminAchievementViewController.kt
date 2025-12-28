package com.oyj.portfolio.admin.context.achievement.controller

import com.oyj.portfolio.admin.context.achievement.service.AdminAchievementService
import com.oyj.portfolio.admin.data.DateFormElementDTO
import com.oyj.portfolio.admin.data.FormElementDTO
import com.oyj.portfolio.admin.data.SelectFormElementDTO
import com.oyj.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/achievement")
class AdminAchievementViewController(
    private val adminAchievementService: AdminAchievementService
) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            DateFormElementDTO("achieveDate", 5),
            TextFormElementDTO("host", 5),
         )
        model.addAttribute("formElements", formElements)

        val table = adminAchievementService.getAchievementTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuNAme", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
            )
        model.addAllAttributes((pageAttributes))

        return "admin/page-table"
    }
}