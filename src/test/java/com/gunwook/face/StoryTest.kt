package com.gunwook.face

import com.gunwook.face.message.request.StoryForm
import com.gunwook.face.model.Story
import com.gunwook.face.model.User
import com.gunwook.face.repository.StoryRepository
import com.gunwook.face.utils.CodeUtils
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import reactor.core.publisher.Mono
import org.junit.Assert
import org.hamcrest.Matchers

@RunWith(SpringRunner::class)
@WebAppConfiguration
@SpringBootTest
class StoryTest {

    @Autowired
    var storyRepository : StoryRepository? = null

    private lateinit var storyForm : StoryForm
    private lateinit var imgs : List<String>


    @Before
    fun init() {
        storyForm = StoryForm(
                System.currentTimeMillis(),
                "testTitle ${System.currentTimeMillis()}",
                "testTags ${System.currentTimeMillis()}",
                "testMessage ${System.currentTimeMillis()}"
        )


        imgs = listOf("2019/12/9/1575896651473-b0e6f6d1947128643fbf29b53ffa499c.album")
    }

    @Test
    fun save() {
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
                this.id = 1.toLong()
                tempModel.user = this
            }

            val model = it.save(tempModel)

            Assert.assertThat(model ,  Matchers.`is`(notNullValue()))
        }
    }

    @Test
    fun get() {
        storyRepository?.findStoryList(30 , 0)?.let {
            Assert.assertThat(it ,  Matchers.`is`(notNullValue()))
        }
    }

}