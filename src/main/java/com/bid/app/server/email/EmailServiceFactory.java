package com.bid.app.server.email;


import com.bid.app.server.bootstrap.AbstractServiceFactory;

public class EmailServiceFactory extends AbstractServiceFactory {

	public EmailServiceFactory(String serviceName, int ServiceTypeId) {
		super(serviceName, ServiceTypeId);
	}

	@Override
	public void createInstance(int serviceId) {
		new EmailServiceImpl(this.getServiceName(),this.getServiceTypeId(),serviceId);

	}

}
