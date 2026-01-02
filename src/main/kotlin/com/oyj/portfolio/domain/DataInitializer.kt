package com.oyj.portfolio.domain

import com.oyj.portfolio.domain.constant.SkillType
import com.oyj.portfolio.domain.entity.*
import com.oyj.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {
    @PostConstruct
    fun initializeData() {
        println("스프링이 실행되었습니다. 테이트 데이터를 초기화합니다.")

        val achievements = mutableListOf(
            Achievement(
                title = "정보처리기사",
                description = "2020년 5월 취득",
                host = "대한민국",
                achievedDate = LocalDate.of(2020, 5, 1),
                isActive = true
            ),
            Achievement(
                title = "운전면허증",
                description = "2014년 7월 취득",
                host = "대한민국",
                achievedDate = LocalDate.of(2020, 5, 1),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "개발을 합니다 백엔드를 공부합니다.", isActive = true),
            Introduction(content = "할 줄 아는건 안드로이드 개발입니다.", isActive = true),
            Introduction(content = "백엔드 개발을 하고싶습니다.", isActive = true)
        )

        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/oyj7677", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com/in/yeongjae-oh-2b1999269/", isActive = true)
        )

        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "한경대",
            description = "컴퓨터공학 전공",
            startYear = 2012,
            startMonth = 3,
            endYear = 2018,
            endMonth = 2,
            isActive = true,
        )

        experience1.addDetails(
            details = mutableListOf(
                ExperienceDetail(content = "GPA 3.17/4.5", isActive = true),
                ExperienceDetail(content = "학점은행제 병행", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "미디어젠",
            description = "안드로이드 개발",
            startYear = 2025,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true,
        )

        experience2.addDetails(
            details = mutableListOf(
                ExperienceDetail(content = "음성인식 기반 앱 개발", isActive = true),
                ExperienceDetail(content = "코드 리팩터링", isActive = true)
            )
        )

        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "Java", type = SkillType.LANGUAGES.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGES.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORKS.name, isActive = true)
        val android = Skill(name = "Android", type = SkillType.TOOL.name, isActive = true)

        skillRepository.saveAll(mutableListOf(java, kotlin, spring, android))

        val project1 = Project(
            name = "유기묘 발견",
            description = "이런 저런 서비스 입니다.",
            startYear = 2022,
            startMonth = 9,
            endYear = 2022,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            details = mutableListOf(
                ProjectDetail(content = "백엔드 개발 담당", url = null, isActive = true),
                ProjectDetail(content = "Spring Boot를 사용한 REST API 개발", url = null, isActive = true),
                ProjectDetail(content = "AWS RDS를 활용한 데이터베이스 설계 및 관리", url = null, isActive = true),
            )
        )

        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = kotlin)
            )
        )

        val project2 = Project(
            name = "프로젝트 22222",
            description = "두번재 프로젝트입니다.",
            startYear = 2024,
            startMonth = 1,
            endYear = 2024,
            endMonth = 10,
            isActive = true
        )

        project2.addDetails(
            details = mutableListOf(
                ProjectDetail(content = "안드로이드", url = null, isActive = true),
                ProjectDetail(content = "개발 했겠지", url = null, isActive = true),
                ProjectDetail(content = "무언가 했다.", url = null, isActive = true),
            )
        )

        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = kotlin),
                ProjectSkill(project = project2, skill = android),
            )
        )

        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$HswVtebqAAlBR.VQZE6wGumlrZFZ6vjG3JOESlVTV4YFOQCOEhOIi"
        )

        accountRepository.save(account)
    }

}