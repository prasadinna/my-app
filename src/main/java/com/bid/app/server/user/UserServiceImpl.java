package com.bid.app.server.user;

import com.bid.app.server.bootstrap.AbstractService;
import com.google.gson.Gson;

public class UserServiceImpl extends AbstractService implements IUserService {
	private UserService userService;
	protected UserServiceImpl(String serviceName, int serviceTypeId,
			int serviceId, UserService userService) {
		super(serviceName, serviceTypeId, serviceId);
		this.userService = userService;
	}
	@Override
	public String addUser(User user) {
		userService.createUser(user);
		Gson gson = new Gson();
		String json = gson.toJson(user);
		return json;
	}

}
