package com.gunwook.face.service

import com.gunwook.face.model.Chat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Service
import java.util.*

@Service
class RedisPublisher {

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String , Any>

    fun publish(topic : ChannelTopic , message : Chat) {
        redisTemplate.convertAndSend(topic.topic, message)
    }
}