package com.bid.app.server.user;

import com.bid.app.server.bootstrap.AbstractServiceFactory;

public class UserServiceFactory extends AbstractServiceFactory {
	private UserService userService;
	protected UserServiceFactory(String serviceName, int ServiceTypeId,UserService uservice) {
		super(serviceName, ServiceTypeId);
		userService = uservice;
	}

	@Override
	public void createInstance(int serviceId) {
		UserServiceImpl serviceImpl = new UserServiceImpl(this.getServiceName(),this.getServiceTypeId(),serviceId,userService);
		serviceImpl.setMessageRegistry(this.getMessageRegistry());
	}

}
