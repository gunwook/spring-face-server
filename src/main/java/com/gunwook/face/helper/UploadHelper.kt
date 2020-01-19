package com.gunwook.face.helper

import com.gunwook.face.service.S3Uploader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

@Service
open class UploadHelper {

    @Autowired
    var s3Uploader : S3Uploader? = null

    @Throws(IOException::class)
    fun convertMultiPartToFile(file: MultipartFile): File {
        val convFile = File(Objects.requireNonNull(file.originalFilename))
        val fos = FileOutputStream(convFile)
        fos.write(file.bytes)
        fos.close()
        return convFile
    }

    fun uploadFiles(multipartFiles: List<MultipartFile>): MutableList<String>? {
        val fileUrls : MutableList<String> = mutableListOf()
        try {
            for (multipartFile in multipartFiles) {
                val file = convertMultiPartToFile(multipartFile)
                val fileName = generateFileName(multipartFile)
                if (s3Uploader?.upload(fileName, file) == false) {
                    return null
                }

                fileUrls.add(fileName)
                file.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return fileUrls
    }


    private fun generateFileName(multiPart: MultipartFile): String {
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val month = Calendar.getInstance().get(Calendar.MONTH) + 1
        val day = Calendar.getInstance().get(Calendar.DATE)
        return "$year/$month/$day/${Date().time}-${multiPart.originalFilename?.replace(" ", "_")}"
    }
}
