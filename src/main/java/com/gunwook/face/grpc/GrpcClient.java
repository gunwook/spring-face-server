package com.gunwook.face.grpc;

import com.gunwook.face.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@Component
public class GrpcClient {

  private ChatServiceGrpc.ChatServiceBlockingStub chatServiceBlockingStub;

  @PostConstruct
  public void init() {
    ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress("localhost", 6565).usePlaintext().build();

    chatServiceBlockingStub =
        ChatServiceGrpc.newBlockingStub(managedChannel);
  }

  public Iterator<ChatModel> test(long firstName) {
    Auth person = Auth.newBuilder().setUserId(firstName).build();

    return chatServiceBlockingStub.recentList(person);
  }
}
