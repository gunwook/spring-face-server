package com.gunwook.face.message.request

import lombok.Getter
import lombok.Setter

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Getter
@Setter
class EmailForm {

    @NotBlank
    var email : String = ""

    @NotBlank
    var subject: String = ""

    @NotBlank
    var content : String = ""
}