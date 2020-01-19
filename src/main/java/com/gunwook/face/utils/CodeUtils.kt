package com.gunwook.face.utils

object CodeUtils {

    const val LIMIT = "limit"
    const val OFFSET = "offset"
    const val VISIBLE = "y"
    const val INVISIBLE = "n"

    object Error {
        @JvmField val RESPONSE_TYPE_ERROR = "RESPONSE TYPE ERROR"
        @JvmField val SERVER_ERROR = "SERVER ERROR"
        @JvmField val GRPC_CONNECT_ERROR = "GRPC CONNECT ERROR"
    }

    object Parameter {
        const val USERNAME = "username"
        const val USER_ID = "user_id"
        const val CREATE_AT = "create_at"
        const val SEND_USER_ID = "send_user_id"
        const val PROFILE_IMG = "profile_img"
        const val MESSAGE = "message"
    }
}