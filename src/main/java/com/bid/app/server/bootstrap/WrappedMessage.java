package com.bid.app.server.bootstrap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

public class WrappedMessage implements Serializable{
	private int messageId;
	private String jsonMessage;
	public WrappedMessage(){
		
	}
	public WrappedMessage(int messageId, String msg){
		this.messageId = messageId;
		this.jsonMessage = msg;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getJsonMessage() {
		return jsonMessage;
	}
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}
	
	@Override
	public String toString(){
		return messageId+":"+jsonMessage;
	}
}
