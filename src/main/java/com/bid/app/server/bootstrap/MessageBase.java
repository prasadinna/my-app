package com.bid.app.server.bootstrap;

public abstract class MessageBase {
	private int messageId;
	public static int MESSAGE_ID;
	
	public static void setMessage_ID(int messageId){
		MESSAGE_ID = messageId;
	}
	
	public void setMessageId(int messageId){
		this.messageId = messageId;
		MESSAGE_ID = messageId;
	}
	
	public int getMessageId(){
		return messageId;
	}
	
	public abstract MessageBase handleMessage(Service currentService);
}
