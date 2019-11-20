package com.bid.app.server.bootstrap;

import com.google.gson.Gson;

public abstract class AbstractService implements Service{
	private String serviceName;
	private Integer serviceTypeId;
	private Integer serviceId;
	private String className;
	private ServiceFactory serviceFactory;
	private ServiceMessageRegistry messageRegistry;
	protected AbstractService(String serviceName,int serviceTypeId, int serviceId) {
		this.serviceName = serviceName;
		this.serviceTypeId = serviceTypeId;
		this.serviceId = serviceId;
		className = serviceName;
		
		init();
	}
	
	private void init(){
		ServiceInvocationHandler invHandler = new ServiceInvocationHandler(this);
		ServiceRegistry.getInstance().setService(invHandler);
	}
	public Integer getServiceTypeId() {
		return serviceTypeId;
	}

	protected void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	protected void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	@Override
	public String serviceName() {
		return serviceName;
	}
	@Override
	public MessageBase handleMessage(WrappedMessage wrappedMessage){
	   int currentMessageId = wrappedMessage.getMessageId();
	   Class<? extends MessageBase> messageClass = messageRegistry.getMessage(currentMessageId);
	   MessageBase message = JsonMessageUtil.convertToMessageBase(messageClass, wrappedMessage.getJsonMessage());
	   return message.handleMessage(this);
	}

	public ServiceMessageRegistry getMessageRegistry() {
		return messageRegistry;
	}

	public void setMessageRegistry(ServiceMessageRegistry messageRegistry) {
		this.messageRegistry = messageRegistry;
	}
	
	@Override
	public int getMessageIdForclass(Class<? extends MessageBase> messageClass){
		return messageRegistry.getMessageIfForClass(messageClass);
	}

}

