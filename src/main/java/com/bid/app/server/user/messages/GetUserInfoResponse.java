package com.bid.app.server.user.messages;


import com.bid.app.server.bootstrap.MessageBase;
import com.bid.app.server.bootstrap.Service;

public class GetUserInfoResponse extends MessageBase{
	private int userId;
	private String userName;
	private String Status;
	public GetUserInfoResponse(){}
	@Override
	public MessageBase handleMessage(Service currentService) {
		// TODO Auto-generated method stub
		return null;
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
