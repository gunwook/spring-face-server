// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Chat.proto

package com.gunwook.face;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_gunwook_face_ChatModel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_gunwook_face_ChatModel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_gunwook_face_Auth_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_gunwook_face_Auth_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_gunwook_face_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_gunwook_face_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nChat.proto\022\020com.gunwook.face\"\242\001\n\tChatM" +
      "odel\022\017\n\007chat_id\030\001 \001(\003\022\021\n\tuser_name\030\002 \001(\t" +
      "\022\017\n\007user_id\030\003 \001(\003\022\021\n\tcreate_at\030\004 \001(\003\022\024\n\014" +
      "send_user_id\030\005 \001(\003\022\023\n\013profile_img\030\006 \001(\t\022" +
      "\021\n\tdelete_at\030\007 \001(\003\022\017\n\007message\030\010 \001(\t\"\027\n\004A" +
      "uth\022\017\n\007user_id\030\001 \001(\003\"L\n\004User\022\017\n\007user_id\030" +
      "\002 \001(\003\022\024\n\014send_user_id\030\003 \001(\003\022\r\n\005limit\030\004 \001" +
      "(\005\022\016\n\006offset\030\005 \001(\0052\333\001\n\013ChatService\022C\n\nre" +
      "centList\022\026.com.gunwook.face.Auth\032\033.com.g" +
      "unwook.face.ChatModel0\001\022A\n\010chatList\022\026.co" +
      "m.gunwook.face.User\032\033.com.gunwook.face.C" +
      "hatModel0\001\022D\n\004send\022\033.com.gunwook.face.Ch" +
      "atModel\032\033.com.gunwook.face.ChatModel(\0010\001" +
      "B\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_gunwook_face_ChatModel_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_gunwook_face_ChatModel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_gunwook_face_ChatModel_descriptor,
        new java.lang.String[] { "ChatId", "UserName", "UserId", "CreateAt", "SendUserId", "ProfileImg", "DeleteAt", "Message", });
    internal_static_com_gunwook_face_Auth_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_gunwook_face_Auth_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_gunwook_face_Auth_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_com_gunwook_face_User_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_gunwook_face_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_gunwook_face_User_descriptor,
        new java.lang.String[] { "UserId", "SendUserId", "Limit", "Offset", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
