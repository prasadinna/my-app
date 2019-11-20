package com.bid.app.server.email;

public class GenericEmailContentHandlerImpl implements IEmailContentHandler {
	private String content;
	public GenericEmailContentHandlerImpl(String content){
		this.content = content;
	}
	@Override
	public String getContent() {
		return content;
	}

}
