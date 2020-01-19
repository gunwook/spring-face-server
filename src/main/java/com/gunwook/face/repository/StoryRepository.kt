package com.gunwook.face.repository

import com.gunwook.face.message.request.PagingForm
import com.gunwook.face.model.Story
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface StoryRepository : JpaRepository<Story, Long> {

    @Query(value = "SELECT * FROM story LIMIT ?1 OFFSET ?2" , nativeQuery = true)
    fun findStoryList(limit : Int , offset : Int) : List<Story>

}
