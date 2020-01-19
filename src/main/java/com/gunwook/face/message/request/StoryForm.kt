package com.gunwook.face.message.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class StoryForm(
        @NotBlank var story_date : Long,
        @NotBlank var story_title : String,
        @NotBlank var story_tag : String,
        @NotBlank var story_message : String)