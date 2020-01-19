package com.gunwook.face.grpc;

import com.gunwook.face.*;
import com.gunwook.face.model.Chat;
import com.gunwook.face.repository.ChatRepository;
import com.gunwook.face.repository.UserRepository;
import com.gunwook.face.service.RedisPublisher;
import com.gunwook.face.utils.CodeUtils;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;

@GRpcService
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
    private Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisPublisher redisPublisher;

    @Override
    public void recentList(Auth request, StreamObserver<ChatModel> responseObserver) {
        if (request == null) {
            responseObserver.onError(new Throwable(CodeUtils.Error.RESPONSE_TYPE_ERROR));
            return;
        }
        List<Chat> dbModel = chatRepository.findRecentAll(request.getUserId());

        try {
            for (Chat chat : dbModel) {
                responseObserver.onNext(ChatModel.newBuilder()
                        .setChatId(chat.getChat_id() == null ? 0 : chat.getChat_id())
                        .setUserName(chat.getUser_name())
                        .setUserId(chat.getUser_id())
                        .setCreateAt(chat.getCreate_at())
                        .setSendUserId(chat.getSend_user_id())
                        .setProfileImg(chat.getProfile_img())
                        .setDeleteAt(chat.getDelete_at())
                        .setMessage(chat.getMessage())
                        .build());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseObserver.onError(new Throwable(CodeUtils.Error.SERVER_ERROR));
        }finally {
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

            responseObserver.onCompleted();
        }
    }

    @Override
    public void chatList(User request, StreamObserver<ChatModel> responseObserver) {
        if (request == null) {
            responseObserver.onError(new Throwable(CodeUtils.Error.RESPONSE_TYPE_ERROR));
            return;
        }

        List<Chat> dbModel = chatRepository.findByUserAll(request.getUserId(), request.getSendUserId(), request.getLimit(), request.getOffset() * request.getLimit());

        try {
            for (Chat chat : dbModel) {
                ChatModel model = ChatModel.newBuilder()
                        .setChatId(chat.getChat_id() == null ? 0 : chat.getChat_id())
                        .setUserName(chat.getUser_name())
                        .setUserId(chat.getUser_id())
                        .setCreateAt(chat.getCreate_at())
                        .setSendUserId(chat.getSend_user_id())
                        .setProfileImg(chat.getProfile_img())
                        .setDeleteAt(chat.getDelete_at())
                        .setMessage(chat.getMessage())
                        .build();

                responseObserver.onNext(model);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseObserver.onError(new Throwable(CodeUtils.Error.SERVER_ERROR));
        }finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<ChatModel> send(StreamObserver<ChatModel> responseObserver) {
        return new StreamObserver<ChatModel>() {
            @Override
            public void onNext(ChatModel chatModel) {
                Chat model = new Chat();

                model.setUser_name(chatModel.getUserName());
                model.setUser_id(chatModel.getUserId());
                model.setCreate_at(chatModel.getCreateAt());
                model.setSend_user_id(chatModel.getSendUserId());
                model.setProfile_img(chatModel.getProfileImg());
                model.setMessage(chatModel.getMessage());
                chatRepository.save(model);


                com.gunwook.face.model.User user = userRepository.findById(chatModel.getSendUserId()).orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found with -> email : " + chatModel.getSendUserId()));

                model.setFcmToken(user.getFcmToken());

                redisPublisher.publish(new ChannelTopic("Event"), model);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.error(CodeUtils.Error.GRPC_CONNECT_ERROR + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
            }
        };
    }
}
