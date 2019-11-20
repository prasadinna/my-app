package com.bid.app.server.bootstrap;

public interface ServiceFactory {
	public void createInstance(int serviceId);
	public Service getInstanceByClass();
	public Service getInstanceById(Integer serviceId);
	public Service removeInstance(Service service);
}
