package com.gunwook.face.service

import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.transfer.TransferManagerBuilder
import com.gunwook.face.controller.StoryAPIs
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.util.logging.Logger
import javax.annotation.PostConstruct
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class S3Uploader {

    private var amazonS3 : AmazonS3? = null

    @Value("\${cloud.aws.s3.bucket}")
    private var bucket : String? = ""

    @Value("\${cloud.aws.accessKey}")
    private var accessKey : String? = ""

    @Value("\${cloud.aws.secretKey}")
    private var secretKey : String? = ""

    fun upload(fileName : String , file :  File) : Boolean{
            try {
                val credentials = BasicAWSCredentials(this.accessKey, this.secretKey)
                this.amazonS3 = AmazonS3ClientBuilder.standard()
                        .withRegion(Regions.AP_NORTHEAST_2)
                        .withCredentials(AWSStaticCredentialsProvider(credentials)).build()

                amazonS3?.putObject(PutObjectRequest(bucket , fileName , file).withCannedAcl(CannedAccessControlList.PublicRead))
                return true
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            } catch (e: AmazonServiceException) {
                e.printStackTrace()
                return false
            } catch (e: AmazonClientException) {
                e.printStackTrace()
                return false
            } catch (e: InterruptedException) {
                e.printStackTrace()
                return false
            }
    }
}