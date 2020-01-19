package com.gunwook.face.controller

import com.google.gson.Gson
import com.gunwook.face.message.request.PagingForm
import com.gunwook.face.message.request.StoryForm
import com.gunwook.face.message.response.ResponseMessage
import com.gunwook.face.model.Story
import com.gunwook.face.repository.StoryRepository
import com.gunwook.face.utils.CodeUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid
import com.gunwook.face.helper.UploadHelper
import com.gunwook.face.model.User
import org.springframework.web.multipart.MultipartFile


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/story")
class StoryAPIs {

    private val logger = LoggerFactory.getLogger(StoryAPIs::class.java)

    @Autowired
    var uploadHelper : UploadHelper? = null

    @Autowired
    var storyRepository : StoryRepository? = null

    @PostMapping("")
    fun saveToStory(@RequestHeader(CodeUtils.Parameter.USER_ID) userId : String , @RequestParam("files") files : List<MultipartFile>, @Valid storyForm: StoryForm) : Mono<ResponseEntity<*>> {
        try {
            val imgs = uploadHelper?.uploadFiles(files) ?: return Mono.just(ResponseEntity(ResponseMessage("Faild Save the Model" , 500),HttpStatus.BAD_REQUEST))

            storyRepository?.let {
                val tempModel = Story(
                        story_imgs = imgs,
                        story_date = storyForm.story_date,
                        story_title = storyForm.story_title,
                        story_message = storyForm.story_message,
                        story_tag = storyForm.story_tag,
                        story_visible = CodeUtils.VISIBLE
                )

                User().apply {
                    this.id = userId.toLong()
                    tempModel.user = this
                }


                logger.info(tempModel.toString())

                val model = it.save(tempModel)

                return Mono.just(ResponseEntity.ok(model))
            }
        }catch (e : Exception){
            logger.error(e.message)
        }

        return Mono.just(ResponseEntity(ResponseMessage("Faild Save the Model" , 500),HttpStatus.BAD_REQUEST))
    }

    @ResponseBody
    @GetMapping("")
    fun getStory(@Valid pagingForm: PagingForm) : Mono<ResponseEntity<*>> {
        try {
            storyRepository?.let {
                val listOfItems = it.findStoryList(pagingForm.limit , pagingForm.page * pagingForm.limit)
                return Mono.just(ResponseEntity.ok(listOfItems))
            }
        }catch (e : java.lang.Exception){
            logger.error(e.message)
        }

        return Mono.just(ResponseEntity(ResponseMessage("Faild GET Story Model" , 500),HttpStatus.BAD_REQUEST))
    }
}