package com.gunwook.face.config

import com.amazonaws.regions.Regions
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class AwsSesConfig {

    @Value("\${AWS_ACCESS_KEY_ID}")
    private val AWS_ACCESS_KEY_ID: String = ""

    @Value("\${AWS_SECRET_KEY}")
    private val AWS_SECRET_KEY: String = ""

    @Bean
    open fun amazonSimpleEmailService(): AmazonSimpleEmailServiceAsync {
        val basicAWSCredentials = BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY)

        return AmazonSimpleEmailServiceAsyncClient.asyncBuilder()
                .withCredentials(AWSStaticCredentialsProvider(basicAWSCredentials))
                .withRegion(Regions.US_EAST_1)
                .build()
    }
}