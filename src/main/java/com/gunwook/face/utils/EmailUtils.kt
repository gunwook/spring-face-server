package com.gunwook.face.utils

import com.amazonaws.services.simpleemail.model.*
import com.gunwook.face.config.AwsSesConfig
import com.gunwook.face.controller.StoryAPIs
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component


@Component
class EmailUtils {

    private val logger = LoggerFactory.getLogger(StoryAPIs::class.java)



    @Value("\${ROOT_EMAIL}")
    private val ROOT_EMAIL : String = ""

    @Autowired
    val config : AwsSesConfig? = null

    fun send(to : List<String> , subject : String, content : String) {
        try {
            val destination = Destination()
                    .withToAddresses(to)

            val message = Message()
                    .withSubject(createContent(subject))
                    .withBody(Body()
                            .withHtml(createContent(content))) // content body는 HTML 형식으로 보내기 때문에 withHtml을 사용합니다.

            SendEmailRequest()
                    .withSource(ROOT_EMAIL)
                    .withDestination(destination)
                    .withMessage(message).apply {
                        config?.amazonSimpleEmailService()?.sendEmail(this)
                    }
        }catch ( e: Exception) {
            logger.error(e.message)
        }
    }


    private fun createContent(text: String): Content {
        return Content()
                .withCharset("UTF-8")
                .withData(text)
    }


}