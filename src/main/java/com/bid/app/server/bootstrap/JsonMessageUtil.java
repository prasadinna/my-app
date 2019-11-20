package com.bid.app.server.bootstrap;

import com.google.gson.Gson;

public class JsonMessageUtil {
	private static Gson gson = new Gson();
	public static MessageBase convertToMessageBase(Class<? extends MessageBase> messageClass, String msgJson){
		MessageBase message = gson.fromJson(msgJson, messageClass);
		return message;
	}
	
	public static WrappedMessage convertToWrappedMessage(MessageBase message){
		int messageId = message.getMessageId();
		String msgJson = gson.toJson(message);
		WrappedMessage wrapMessage = new WrappedMessage(messageId, msgJson);
		return wrapMessage;
	}
	
	public static String toJsonString(Object toConvert){
		return gson.toJson(toConvert);
	}
}
