package com.gunwook.face.repository

import com.gunwook.face.model.Chat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ChatRepository : JpaRepository<Chat, Long> {

    @Query(value = "SELECT * FROM chat WHERE user_id = ?1 AND send_user_id = ?2 LIMIT ?3 OFFSET ?4" , nativeQuery = true)
    fun findByUserAll(user_id : Long , send_user_id : Long  , limit : Int , offset : Int ) : List<Chat>

    @Query(value = "SELECT send_user_id , ANY_VALUE(user_name) , ANY_VALUE(user_id) , ANY_VALUE(create_at) , ANY_VALUE(send_user_id) , ANY_VALUE(profile_img) , ANY_VALUE(delete_at) FROM chat WHERE user_id = ?1 GROUP BY send_user_id ORDER BY max(create_at) DESC" , nativeQuery = true)
    fun findRecentAll(user_id : Long) : List<Chat>

}
