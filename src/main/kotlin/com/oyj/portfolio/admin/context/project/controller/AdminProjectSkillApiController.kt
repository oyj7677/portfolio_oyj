package com.oyj.portfolio.admin.context.project.controller

import com.oyj.portfolio.admin.context.project.form.ProjectForm
import com.oyj.portfolio.admin.context.project.form.ProjectSkillForm
import com.oyj.portfolio.admin.context.project.service.AdminProjectService
import com.oyj.portfolio.admin.context.project.service.AdminProjectSkillService
import com.oyj.portfolio.admin.data.ApiResponse
import com.oyj.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/projects/skills")
class AdminProjectSkillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {

    @PostMapping
    fun postProject(@RequestBody @Validated form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable id: Long): ResponseEntity<Any> {
        adminProjectSkillService.delete(id)

        return ApiResponse.successDelete()
    }
}


