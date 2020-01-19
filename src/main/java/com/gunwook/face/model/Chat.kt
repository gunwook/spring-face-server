package com.gunwook.face.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "chat")
data class Chat(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var chat_id: Long? = 0,

        @Column(nullable = false) var user_name : String,
        @Column(nullable = false) var user_id : Long,
        @Column(nullable = false) var create_at : Long,
        @Column(nullable = false) var send_user_id : Long,
        @Column(nullable = true) var profile_img : String,
        @Column(nullable = true) var delete_at : Long,
        @Column(nullable = false) var message : String,

        var fcmToken : String
) : Serializable {
    constructor() : this(0 , "",0,0,0,"" , 0 , "" ,"" )
}