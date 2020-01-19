package com.gunwook.face.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.gunwook.face.converter.StringListConverter
import com.gunwook.face.utils.CodeUtils
import javax.persistence.*

@Entity
@Table(name = "story")
data class Story(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var story_id: Long? = 0,

        @Column(nullable = true)
        @Convert(converter = StringListConverter::class)
        var story_imgs : List<String>,

        @Column(nullable = false) var story_date : Long,
        @Column(nullable = false) var story_title : String,
        @Column(nullable = true) var story_tag : String,
        @Column(nullable = false) var story_message : String,

        @JsonIgnore
        @Column(nullable = false) var story_visible : String,

        @ManyToOne
        @JoinColumn(name ="users_id")
        var user : User? = null
){
    constructor() : this( 0 , listOf() , 0,"","","", CodeUtils.VISIBLE , null)
}