package com.gunwook.face.message.request

import lombok.Getter
import lombok.Setter

import javax.validation.constraints.*
import kotlin.math.max


@Getter
@Setter
class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    var name: String? = null

    @NotBlank
    @Size(min = 3, max = 50)
    var nickname: String? = null

    @NotBlank
    @Size(max = 60)
    @Email
    var email: String? = null

    @NotBlank
    @Size(max = 10)
    var gender : String? = null

    @NotBlank
    @Size(max = 1000)
    var message : String? = null

    var fcmToken : String? = null

    @NotBlank
    @Size(min = 6, max = 40)
    var password: String? = null
}