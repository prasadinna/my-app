package com.bid.app.server.bootstrap;

public abstract class AbstractServiceFactory implements ServiceFactory {
    private String serviceName;
    private int serviceTypeId;
    private int numberOfInstance =1;
    private ServiceMessageRegistry messageRegistry;
    protected int getNumberOfInstance(){
    	return numberOfInstance;
    }
    
    protected int getServiceTypeId(){
    	return serviceTypeId;
    }
    
    protected String getServiceName(){
    	return serviceName;
    }
    
	protected AbstractServiceFactory(String serviceName,int  ServiceTypeId){
	  this.serviceName = serviceName;	
	  this.serviceTypeId = ServiceTypeId;
	}
    

	/*
	 * Template method which allows the concrete method to create the actual
	 * instance but proxy instance is returned
	 */
	@Override
	public final Service getInstanceByClass() {
		Service service = ServiceRegistry.getInstance().getServiceByName(
				serviceName);
		return service;
	}

	/*
	 * Template method which allows the concrete method to create the actual
	 * instance but proxy instance is returned
	 */
	@Override
	public final Service getInstanceById(Integer serviceId) {
		Service service = ServiceRegistry.getInstance().getServicebyId(
				serviceId);
		return service;
	}

	@Override
	public Service removeInstance(Service service) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ServiceMessageRegistry getMessageRegistry() {
		return messageRegistry;
	}

	public void setMessageRegistry(ServiceMessageRegistry messageRegistry) {
		this.messageRegistry = messageRegistry;
	}

}
