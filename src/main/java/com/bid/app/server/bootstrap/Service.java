package com.bid.app.server.bootstrap;

public interface Service {
  public Integer getServiceId();
  public Integer getServiceTypeId();
  public String  serviceName();
  public MessageBase handleMessage(WrappedMessage wrappedMessage);
  public int getMessageIdForclass(Class<? extends MessageBase> messageClass);
}
