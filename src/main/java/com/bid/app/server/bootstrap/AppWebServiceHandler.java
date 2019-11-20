package com.bid.app.server.bootstrap;

import java.util.Map;

public interface AppWebServiceHandler {
	public String getModuleName();
	public String getComponentName();
	public Object getResponse(Map args, WrappedMessage wrappedmsg);
	public MessageBase getMessage(int messageId);
}
