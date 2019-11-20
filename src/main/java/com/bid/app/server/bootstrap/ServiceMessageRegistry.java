package com.bid.app.server.bootstrap;

public interface ServiceMessageRegistry {
	public Class<? extends MessageBase> getMessage(int messageId);
	public int getMessageIfForClass(Class<? extends MessageBase> messageClass);
}
