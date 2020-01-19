package com.gunwook.face;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: Chat.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "com.gunwook.face.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.gunwook.face.Auth,
      com.gunwook.face.ChatModel> getRecentListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recentList",
      requestType = com.gunwook.face.Auth.class,
      responseType = com.gunwook.face.ChatModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.gunwook.face.Auth,
      com.gunwook.face.ChatModel> getRecentListMethod() {
    io.grpc.MethodDescriptor<com.gunwook.face.Auth, com.gunwook.face.ChatModel> getRecentListMethod;
    if ((getRecentListMethod = ChatServiceGrpc.getRecentListMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getRecentListMethod = ChatServiceGrpc.getRecentListMethod) == null) {
          ChatServiceGrpc.getRecentListMethod = getRecentListMethod = 
              io.grpc.MethodDescriptor.<com.gunwook.face.Auth, com.gunwook.face.ChatModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.gunwook.face.ChatService", "recentList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.Auth.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.ChatModel.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("recentList"))
                  .build();
          }
        }
     }
     return getRecentListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gunwook.face.User,
      com.gunwook.face.ChatModel> getChatListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chatList",
      requestType = com.gunwook.face.User.class,
      responseType = com.gunwook.face.ChatModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.gunwook.face.User,
      com.gunwook.face.ChatModel> getChatListMethod() {
    io.grpc.MethodDescriptor<com.gunwook.face.User, com.gunwook.face.ChatModel> getChatListMethod;
    if ((getChatListMethod = ChatServiceGrpc.getChatListMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getChatListMethod = ChatServiceGrpc.getChatListMethod) == null) {
          ChatServiceGrpc.getChatListMethod = getChatListMethod = 
              io.grpc.MethodDescriptor.<com.gunwook.face.User, com.gunwook.face.ChatModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.gunwook.face.ChatService", "chatList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.ChatModel.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("chatList"))
                  .build();
          }
        }
     }
     return getChatListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.gunwook.face.ChatModel,
      com.gunwook.face.ChatModel> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = com.gunwook.face.ChatModel.class,
      responseType = com.gunwook.face.ChatModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.gunwook.face.ChatModel,
      com.gunwook.face.ChatModel> getSendMethod() {
    io.grpc.MethodDescriptor<com.gunwook.face.ChatModel, com.gunwook.face.ChatModel> getSendMethod;
    if ((getSendMethod = ChatServiceGrpc.getSendMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMethod = ChatServiceGrpc.getSendMethod) == null) {
          ChatServiceGrpc.getSendMethod = getSendMethod = 
              io.grpc.MethodDescriptor.<com.gunwook.face.ChatModel, com.gunwook.face.ChatModel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.gunwook.face.ChatService", "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.ChatModel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.gunwook.face.ChatModel.getDefaultInstance()))
                  .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("send"))
                  .build();
          }
        }
     }
     return getSendMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    return new ChatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void recentList(com.gunwook.face.Auth request,
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      asyncUnimplementedUnaryCall(getRecentListMethod(), responseObserver);
    }

    /**
     */
    public void chatList(com.gunwook.face.User request,
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      asyncUnimplementedUnaryCall(getChatListMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> send(
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecentListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.gunwook.face.Auth,
                com.gunwook.face.ChatModel>(
                  this, METHODID_RECENT_LIST)))
          .addMethod(
            getChatListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.gunwook.face.User,
                com.gunwook.face.ChatModel>(
                  this, METHODID_CHAT_LIST)))
          .addMethod(
            getSendMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.gunwook.face.ChatModel,
                com.gunwook.face.ChatModel>(
                  this, METHODID_SEND)))
          .build();
    }
  }

  /**
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void recentList(com.gunwook.face.Auth request,
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRecentListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void chatList(com.gunwook.face.User request,
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChatListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> send(
        io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.gunwook.face.ChatModel> recentList(
        com.gunwook.face.Auth request) {
      return blockingServerStreamingCall(
          getChannel(), getRecentListMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.gunwook.face.ChatModel> chatList(
        com.gunwook.face.User request) {
      return blockingServerStreamingCall(
          getChannel(), getChatListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RECENT_LIST = 0;
  private static final int METHODID_CHAT_LIST = 1;
  private static final int METHODID_SEND = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECENT_LIST:
          serviceImpl.recentList((com.gunwook.face.Auth) request,
              (io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel>) responseObserver);
          break;
        case METHODID_CHAT_LIST:
          serviceImpl.chatList((com.gunwook.face.User) request,
              (io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.send(
              (io.grpc.stub.StreamObserver<com.gunwook.face.ChatModel>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.gunwook.face.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getRecentListMethod())
              .addMethod(getChatListMethod())
              .addMethod(getSendMethod())
              .build();
        }
      }
    }
    return result;
  }
}
