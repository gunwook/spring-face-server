package com.gunwook.face.message.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PagingForm(
        @NotBlank var page  : Int,
        @NotBlank var limit : Int)