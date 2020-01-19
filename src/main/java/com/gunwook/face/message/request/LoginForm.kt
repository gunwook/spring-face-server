package com.gunwook.face.message.request

import lombok.Getter
import lombok.Setter

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


@Getter
@Setter
class LoginForm {
    @NotBlank
    @Size(min = 3, max = 60)
    var email: String? = null

    @NotBlank
    @Size(min = 6, max = 40)
    var password: String? = null
}