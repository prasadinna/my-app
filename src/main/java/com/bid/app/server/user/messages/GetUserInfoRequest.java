package com.bid.app.server.user.messages;

import com.bid.app.server.bootstrap.MessageBase;
import com.bid.app.server.bootstrap.Service;
import com.bid.app.server.user.IUserService;

public class GetUserInfoRequest extends MessageBase{
	private int userId;
	private String userName;
	public GetUserInfoRequest(){}
	@Override
	public MessageBase handleMessage(Service currentService) {
		IUserService userService = (IUserService)currentService;
		System.out.println("creating the message back response");
		GetUserInfoResponse response  = new GetUserInfoResponse();
		response.setMessageId(userService.getMessageIdForclass(GetUserInfoResponse.class));
		response.setUserId(this.userId);
		response.setUserName(this.getUserName());
		response.setStatus("user info successful");
		return response;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
